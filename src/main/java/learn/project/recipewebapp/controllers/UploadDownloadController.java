package learn.project.recipewebapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import learn.project.recipewebapp.services.IngredientsFilesService;
import learn.project.recipewebapp.services.RecipeFilesService;
import learn.project.recipewebapp.services.RecipeService;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController()
@RequestMapping("files")
@Tag(name = "Импорт и экспорт файлов",
        description = "Операции для отправки и получения (сохранения) файлов")
public class UploadDownloadController {

    private final RecipeFilesService recipeFilesService;
    private final IngredientsFilesService ingredientsFilesService;
    private final RecipeService recipeService;

    public UploadDownloadController(RecipeFilesService recipeFilesService, IngredientsFilesService ingredientsFilesService, RecipeService recipeService) {
        this.recipeFilesService = recipeFilesService;
        this.ingredientsFilesService = ingredientsFilesService;
        this.recipeService = recipeService;
    }

    @GetMapping("recipeExport")
    @Operation(summary = "Сохранение файла с рецептами на компьютер пользователя  в формате json")
    public ResponseEntity<InputStreamResource> downloadRecipesAsJson() throws FileNotFoundException {
        File file = recipeFilesService.getJsonFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok().
                    contentLength(file.length()).
                    contentType(MediaType.APPLICATION_JSON).
                    header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"Recipes.json\"").
                    body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("recipeExportAsTxt")
    @Operation(summary = "NEW !!! Сохранение файла с рецептами на компьютер пользователя в формате txt")
    public ResponseEntity<InputStreamResource> downloadRecipesAsTxt() throws FileNotFoundException {
        File file = recipeFilesService.getTxtFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok().
                    contentLength(file.length()).
                    contentType(MediaType.TEXT_PLAIN).
                    header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"Recipes.txt\"").
                    body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "recipeImport", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Загрузка сохраненного файла с рецептами с компьютера пользователя")
    public ResponseEntity<Void> uploadRecipesFile(@RequestParam MultipartFile inputFile) {
        recipeFilesService.cleanRecipeJsonFile();
        File file = recipeFilesService.getJsonFile();
        if (file != null) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                IOUtils.copy(inputFile.getInputStream(), fos);
                return ResponseEntity.ok().build();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity.internalServerError().build();
    }

    @PostMapping(value = "ingredientsImport", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Загрузка сохраненного файла с ингредиентами с компьютера пользователя")
    public ResponseEntity<Void> uploadIngredientsFile(@RequestParam MultipartFile inputFile) {
        ingredientsFilesService.cleanIngredientsFile();
        File file = ingredientsFilesService.getFile();
        if (file != null) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                IOUtils.copy(inputFile.getInputStream(), fos);
                return ResponseEntity.ok().build();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity.internalServerError().build();
    }
}
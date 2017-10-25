package opa.dropbox.web;

import lombok.RequiredArgsConstructor;
import opa.dropbox.service.StorageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import static opa.dropbox.web.RequestPath.USER_FILE_PATH;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = USER_FILE_PATH)
public class FileController {

    private final StorageService storageService;

    @PostMapping
    public void handleFileUpload(@RequestParam("file") MultipartFile file,
                                 @PathVariable String clientId) {
        storageService.store(file);
    }
}

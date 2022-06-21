package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appwarehouse.entity.Attachment;
import uz.pdp.appwarehouse.payload.CategoryDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.AttachmentService;
import uz.pdp.appwarehouse.service.CategoryService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/Attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @PostMapping
    public Result upload(MultipartHttpServletRequest request) {
        Result result = attachmentService.uploadFileDb(request);
        return result;
    }

    @GetMapping("/downloadDb/{id}")
    public Result download(@PathVariable Integer id, HttpServletResponse response) {
        Result result = attachmentService.downloadFileDb(id, response);
        return result;
    }


}

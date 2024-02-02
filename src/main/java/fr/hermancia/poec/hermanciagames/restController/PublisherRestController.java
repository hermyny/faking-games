package fr.hermancia.poec.hermanciagames.restController;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.hermanciagames.entity.Publisher;
import fr.hermancia.poec.hermanciagames.json_views.JsonViews;
import fr.hermancia.poec.hermanciagames.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/apis/publisher")
public class PublisherRestController {

    private PublisherService publisherService;

    @JsonView(JsonViews.CategoryView.class)
    @GetMapping
    public List<Publisher> findAll() {
        return publisherService.findAll();
    }



}

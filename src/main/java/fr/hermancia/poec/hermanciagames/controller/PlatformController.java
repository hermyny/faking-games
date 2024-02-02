package fr.hermancia.poec.hermanciagames.controller;


import fr.hermancia.poec.hermanciagames.DTO.PlatformDTO;
import fr.hermancia.poec.hermanciagames.service.PlatformService;
import fr.hermancia.poec.hermanciagames.validator.group.ValidationGroup;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/platform", name = "AppPlatform")
public class PlatformController {

    private final PlatformService platformService;

    @GetMapping(path = "", name = "index")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("platform/index");
        mav.addObject("platforms", platformService.findAll(PageRequest.of(0,5)));
        return mav;
    }

    @GetMapping(path = "/new", name = "new")
    public ModelAndView create(
            ModelAndView mav,
            HttpServletRequest httpServletRequest
    ) {
        return getFormByDTO(
                mav,
                new PlatformDTO(),
                httpServletRequest.getRequestURI(),
                false
        );
    }

    @GetMapping(path = "/edit/{id}", name = "edit")
    public ModelAndView edit(
            @PathVariable Long id,
            ModelAndView mav,
            HttpServletRequest httpServletRequest
    ) {
        return getFormByDTO(
                mav,
                platformService.getDTOById(id),
                httpServletRequest.getRequestURI(),
                true
        );
    }

    @PostMapping(path = "/new", name = "newHandler")
    public ModelAndView formHandler(
            @Validated(ValidationGroup.OnPostItem.class) @ModelAttribute("platform") PlatformDTO platformDTO,
            BindingResult result,
            ModelAndView mav
    ) {
        return formHandle(result, mav, platformDTO, null);
    }

    @PostMapping(path = "/edit/{id}", name = "editHandler")
    public ModelAndView formHandler(
            @Validated(ValidationGroup.OnPostItem.class) @ModelAttribute("platform") PlatformDTO platformDTO,
            BindingResult result,
            ModelAndView mav,
            @PathVariable Long id
    ) {
        return formHandle(result, mav, platformDTO, id);
    }

    private ModelAndView getFormByDTO(
            ModelAndView mav,
            PlatformDTO dto,
            String uri,
            boolean isEdit
    ) {
        mav.setViewName("platform/form");
        mav.addObject("platform", dto);
        mav.addObject("action", uri);
        mav.addObject("isEdit", isEdit);
        return mav;
    }

    private ModelAndView formHandle(
            BindingResult result,
            ModelAndView mav,
            PlatformDTO dto,
            Long id
    ) {
        if (result.hasErrors()) {
            mav.setViewName("platform/form");
            return mav;
        }
        platformService.create(dto, id);
        mav.setViewName("redirect:/platform"); // FORCEMENT UN PATH (une URL de route !)
        return mav;
    }
}



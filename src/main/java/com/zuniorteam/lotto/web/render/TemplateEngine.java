package com.zuniorteam.lotto.web.render;

import spark.ModelAndView;
import spark.TemplateEngine;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.Map;

public class TemplateEngine {


    private TemplateEngine() {
    }

    private static final spark.TemplateEngine TEMPLATE_ENGINE = new ThymeleafTemplateEngine();

    public static String render(Map<String, Object> model, String viewName) {
        return TEMPLATE_ENGINE.render(new ModelAndView(model, viewName));
    }

}

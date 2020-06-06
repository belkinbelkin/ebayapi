package com.belkbelk.services;

import com.belkbelk.datastructures.resultobjects.LabeledCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    static Logger logger = LoggerFactory.getLogger(CategoryService.class);

    private List<LabeledCategory> shoesCategories = new ArrayList<>();

    @PostConstruct
    public void init() {

        InputStream stream = this.getClass().getResourceAsStream("/Categories.csv");
        List<String> text = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
        text.forEach(line -> {
            List<String> pair = Arrays.stream(line.split(",")).filter(entry -> !entry.contains("\"\"") && !entry.contains("+") && !entry.contains("-")).collect(Collectors.toList());
            if (pair.size() > 0 && pair.get(0).toLowerCase().contains("shoe")) {
                shoesCategories.add(new LabeledCategory(removeFirstAndLast(pair.get(0)), removeFirstAndLast(pair.get(1))));
            }
        });
        logger.info("Category service initialized");
    }

    public List<LabeledCategory> getCategories() {
        return shoesCategories;
    }

    private String removeFirstAndLast(String s) {
        if (s.length() > 1 && s.startsWith("\"") && s.endsWith("\"")) {
            return s.substring(1, s.length() - 1);
        } else return s;
    }

}

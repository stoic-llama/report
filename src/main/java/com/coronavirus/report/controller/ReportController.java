package com.coronavirus.report.controller;

import com.coronavirus.report.model.LocationStats;
import com.coronavirus.report.service.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReportController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/report")
    public String report (Model model) {
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        model.addAttribute("locationStats", allStats);
        return "report";
    }
}



package com.losBicos.ControlTechV1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.losBicos.ControlTechV1.Services.DashboardService;
import com.losBicos.ControlTechV1.dto.DashboardDTO;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
     @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<DashboardDTO> getIndicadores() {
        DashboardDTO dto = dashboardService.getIndicadores();
        return ResponseEntity.ok(dto);
    }
}

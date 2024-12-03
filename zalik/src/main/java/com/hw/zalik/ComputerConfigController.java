package com.hw.zalik;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configs")
public class ComputerConfigController {

    @Autowired
    private ComputerConfigService service;

    @GetMapping
    public List<ComputerConfig> getAllConfigs() {
        return service.getAllConfigs();
    }

    @PostMapping
    public ResponseEntity<ComputerConfig> createConfig(@Valid @RequestBody ComputerConfig config) {
        // Валідація обмежень: або HDD, або SSD, або обидва
        if (config.getSsd() == null && config.getHdd() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        // Тільки одна ОС
        if (config.getOs() == null) {
            config.setOs(ComputerConfig.OS.NONE);
        }

        return ResponseEntity.ok(service.saveConfig(config));
    }
}

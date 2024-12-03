package com.hw.zalik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerConfigService {

    @Autowired
    private ComputerConfigRepository repository;

    public List<ComputerConfig> getAllConfigs() {
        return repository.findAll();
    }

    public ComputerConfig saveConfig(ComputerConfig config) {
        return repository.save(config);
    }
}
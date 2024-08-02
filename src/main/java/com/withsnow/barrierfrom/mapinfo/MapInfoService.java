package com.withsnow.barrierfrom.mapinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MapInfoService {
    @Autowired
    private MapInfoRepository repository;

    public List<MapInfo> getAllLocations() {
        return repository.findAll();
    }

    public MapInfo getLocationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public MapInfo saveLocation(MapInfo location) {
        return repository.save(location);
    }

    public void deleteLocation(Long id) {
        repository.deleteById(id);
    }
}

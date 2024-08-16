package com.withsnow.barrierfrom.mapinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maps")
public class MapInfoController {

    private final MapInfoService service;

    @Autowired
    public MapInfoController(MapInfoService service) {
        this.service = service;
    }

    @GetMapping
    public List<MapInfo> getAllLocations() {
        return service.getAllLocations();
    }

    @GetMapping("/{id}")
    public MapInfo getLocationById(@PathVariable Long id) {
        return service.getLocationById(id);
    }

    @PostMapping
    public MapInfo createLocation(@RequestBody MapInfo location) {
        return service.saveLocation(location);
    }

    @PutMapping("/{id}")
    public MapInfo updateLocation(@PathVariable Long id, @RequestBody MapInfo location) {
        MapInfo existingLocation = service.getLocationById(id);
        if (existingLocation != null) {
            location.setMapId(id);
            return service.saveLocation(location);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        service.deleteLocation(id);
    }

    @GetMapping("/category/{category}")
    public List<MapInfo> getByCategory(@PathVariable Category category) {
        return service.findByCategory(category);
    }

    @GetMapping("/search/name")
    public List<MapInfo> getByName(@RequestParam String name) {
        return service.findByName(name);
    }

    @GetMapping("/search/address")
    public List<MapInfo> getByAddress(@RequestParam String address) {
        return service.findByAddress(address);
    }

    @GetMapping("/search/coordinates")
    public List<MapInfo> getByCoordinates(@RequestParam double minLat,
                                          @RequestParam double maxLat,
                                          @RequestParam double minLon,
                                          @RequestParam double maxLon) {
        return service.findWithinCoordinates(minLat, maxLat, minLon, maxLon);
    }
}

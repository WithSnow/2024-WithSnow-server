package com.withsnow.barrierfrom.mapinfo;

import com.withsnow.barrierfrom.search.SearchHistoryService;
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

    @GetMapping("/name")
    public List<MapInfo> getLocationsByName(@RequestParam String name) {
        return service.findByName(name);
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

    @Autowired
    private SearchHistoryService searchHistoryService;

    @GetMapping("/category/{category}")
    public List<MapInfo> getByCategory(@PathVariable String category) {
        List<MapInfo> results = service.findByCategory(category);
        searchHistoryService.saveSearchHistory(category, "CATEGORY", null, null, null, results.size());
        return results;
    }

    @GetMapping("/search/name")
    public List<MapInfo> getByName(@RequestParam String name) {
        List<MapInfo> results = service.findByName(name);
        searchHistoryService.saveSearchHistory(name, "NAME", null, null, null, results.size());
        return results;
    }

    @GetMapping("/search/address")
    public List<MapInfo> getByAddress(@RequestParam String address) {
        List<MapInfo> results = service.findByAddress(address);
        searchHistoryService.saveSearchHistory(address, "ADDRESS", null, null, null, results.size());
        return results;
    }

    @GetMapping("/search/coordinates")
    public List<MapInfo> getByCoordinates(@RequestParam double minLat,
                                          @RequestParam double maxLat,
                                          @RequestParam double minLon,
                                          @RequestParam double maxLon) {
        List<MapInfo> results = service.findWithinCoordinates(minLat, maxLat, minLon, maxLon);
        searchHistoryService.saveSearchHistory("Coordinates Search", "COORDINATES", (minLat + maxLat) / 2, (minLon + maxLon) / 2, null, results.size());
        return results;
    }

}

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

    // 카테고리로 검색
    public List<MapInfo> findByCategory(String category) {
        return repository.findByCategory(category);
    }

    // 이름으로 검색
    public List<MapInfo> findByName(String name) {
        return repository.findByNameContaining(name);
    }

    // 주소로 검색
    public List<MapInfo> findByAddress(String address) {
        return repository.findByAddressContaining(address);
    }

    // 특정 범위 내의 좌표로 검색
    public List<MapInfo> findWithinCoordinates(double minLat, double maxLat, double minLon, double maxLon) {
        return repository.findWithinCoordinates(minLat, maxLat, minLon, maxLon);
    }
}

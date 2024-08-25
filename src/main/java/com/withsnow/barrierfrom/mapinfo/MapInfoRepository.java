package com.withsnow.barrierfrom.mapinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MapInfoRepository extends JpaRepository<MapInfo, Long> {
    // 카테고리로 검색
    List<MapInfo> findByCategory(String category);

    // 이름으로 검색
    List<MapInfo> findByNameContaining(String name);

    // 주소로 검색
    List<MapInfo> findByAddressContaining(String address);

    // 특정 범위 내의 좌표로 검색 (경도와 위도의 범위를 설정)
    @Query("SELECT m FROM MapInfo m WHERE m.latitude BETWEEN :minLat AND :maxLat AND m.longitude BETWEEN :minLon AND :maxLon")
    List<MapInfo> findWithinCoordinates(
            @Param("minLat") double minLat,
            @Param("maxLat") double maxLat,
            @Param("minLon") double minLon,
            @Param("maxLon") double maxLon
    );
}

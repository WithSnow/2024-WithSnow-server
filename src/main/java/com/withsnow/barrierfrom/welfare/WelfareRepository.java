package com.withsnow.barrierfrom.welfare;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Welfare 엔티티에 대한 데이터 접근을 처리하는 리포지토리 인터페이스입니다.
 */
public interface WelfareRepository extends JpaRepository<Welfare, Long> {
}

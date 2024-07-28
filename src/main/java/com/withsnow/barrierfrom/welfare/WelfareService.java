package com.withsnow.barrierfrom.welfare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Welfare 엔티티에 대한 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@Service
public class WelfareService {

    @Autowired
    private WelfareRepository welfareRepository;

    /**
     * 모든 Welfare 엔티티를 조회합니다.
     * 
     * @return 모든 Welfare 엔티티의 리스트
     */
    public List<Welfare> getAllWelfares() {
        return welfareRepository.findAll();
    }

    /**
     * 주어진 ID에 해당하는 Welfare 엔티티를 조회합니다.
     * 
     * @param id 조회할 Welfare의 ID
     * @return Welfare 엔티티 (Optional로 감싸져 있음)
     */
    public Optional<Welfare> getWelfareById(Long id) {
        return welfareRepository.findById(id);
    }

    /**
     * 새로운 Welfare 엔티티를 생성합니다.
     * 
     * @param welfare 생성할 Welfare 엔티티
     * @return 생성된 Welfare 엔티티
     */
    public Welfare createWelfare(Welfare welfare) {
        welfare.setCreatedAt(LocalDateTime.now());
        return welfareRepository.save(welfare);
    }

    /**
     * 주어진 ID에 해당하는 Welfare 엔티티의 상태를 업데이트합니다.
     * 
     * @param id 상태를 업데이트할 Welfare의 ID
     * @param status 업데이트할 상태 값
     * @return 업데이트된 Welfare 엔티티
     */
    public Welfare updateWelfareStatus(Long id, String status) {
        Welfare welfare = welfareRepository.findById(id).orElseThrow(() -> new RuntimeException("Welfare not found"));
        welfare.setStatus(status);
        return welfareRepository.save(welfare);
    }
}

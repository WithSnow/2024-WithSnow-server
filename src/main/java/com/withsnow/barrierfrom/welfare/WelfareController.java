package com.withsnow.barrierfrom.welfare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST 컨트롤러로 Welfare 엔티티에 대한 HTTP 요청을 처리합니다.
 */
@RestController
@RequestMapping("/welfares")
public class WelfareController {

    @Autowired
    private WelfareService welfareService;

    /**
     * 모든 Welfare 엔티티를 조회합니다.
     * 
     * @return 모든 Welfare 엔티티의 리스트
     */
    @GetMapping
    public List<Welfare> getAllWelfares() {
        return welfareService.getAllWelfares();
    }

    /**
     * 주어진 ID에 해당하는 Welfare 엔티티를 조회합니다.
     * 
     * @param welfare_id 조회할 Welfare의 ID
     * @return Welfare 엔티티 (Optional로 감싸져 있음)
     */
    @GetMapping("/{welfare_id}")
    public Optional<Welfare> getWelfareById(@PathVariable Long welfare_id) {
        return welfareService.getWelfareById(welfare_id);
    }

    /**
     * 새로운 Welfare 엔티티를 생성합니다.
     * 
     * @param welfare 생성할 Welfare 엔티티
     * @return 생성된 Welfare 엔티티
     */
    @PostMapping
    public Welfare createWelfare(@RequestBody Welfare welfare) {
        return welfareService.createWelfare(welfare);
    }

    /**
     * 주어진 ID에 해당하는 Welfare 엔티티의 상태를 업데이트합니다.
     * 
     * @param call_id 상태를 업데이트할 Welfare의 ID
     * @param status 업데이트할 상태 값
     * @return 업데이트된 Welfare 엔티티
     */
    @PostMapping("/{call_id}")
    public Welfare updateWelfareStatus(@PathVariable Long call_id, @RequestBody String status) {
        return welfareService.updateWelfareStatus(call_id, status);
    }
}

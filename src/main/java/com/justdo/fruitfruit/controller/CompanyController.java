package com.justdo.fruitfruit.controller;

import com.justdo.fruitfruit.model.dto.CompanyDTO;
import com.justdo.fruitfruit.model.dto.UserDTO;
import com.justdo.fruitfruit.model.service.CommonService;
import com.justdo.fruitfruit.model.service.CompanyService;
import com.justdo.fruitfruit.view.CompanyResultMessage;

import java.util.Map;

public class CompanyController {
    private final CommonService commonService = new CommonService();

    private final CompanyService companyService = new CompanyService();
    private final CompanyResultMessage companyResultMessage = new CompanyResultMessage();

    /***
     * 구매자에서 판매자로 전환하는 함수
     * @param param 입력받은 회사정보
     */
    public void insertCompany(Map<String, String> param) {
        int userSeq = Integer.parseInt(param.get("userSeq"));

        // 이미 존재하는 userSeq인지 확인
        if(companyService.checkUserSeqExists(userSeq)){
            System.out.println("\n이미 판매자 전환이 신청되어 승인대기중 또는 판매자등록이 완료된 계정입니다.\n");
            return;
        }

        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setUserSeq(userSeq);
        companyDTO.setCompanyName(param.get("companyName"));
        companyDTO.setCompanyPhone(param.get("companyPhone"));
        companyDTO.setCompanyNum(param.get("companyNum"));
        companyDTO.setCompanyAddress(param.get("companyAddress"));

        int result = companyService.insertCompany(companyDTO);
        if(result > 0) {
            companyResultMessage.companyInsertResult("insertSuccess");
        } else {
            companyResultMessage.companyInsertResult("insertError");
        }
    }
}

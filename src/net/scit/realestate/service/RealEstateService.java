package net.scit.realestate.service;

import net.scit.realestate.vo.RealEstate;

import java.util.List;

/**
 * projectName     :RealEstate
 * fileName        :RealEstateService
 * author          :yuuna
 * since           :2022/04/25
 */
public interface RealEstateService {

    public void regist(RealEstate realEstate);

    public RealEstate getAddr(String address);

    public int delete(String address);

    public int update(RealEstate realEstate);

    public List<RealEstate> selectAll();

}

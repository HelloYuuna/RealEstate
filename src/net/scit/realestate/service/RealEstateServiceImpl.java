package net.scit.realestate.service;

import net.scit.realestate.vo.BuyingAndSell;
import net.scit.realestate.vo.Charter;
import net.scit.realestate.vo.MonthlyRent;
import net.scit.realestate.vo.RealEstate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.*;

/**
 * projectName     :RealEstate
 * fileName        :RealEstateServiceImpl
 * author          :yuuna
 * since           :2022/04/25
 */
public class RealEstateServiceImpl implements RealEstateService{
    List<RealEstate> realEstateList = new ArrayList<>();
    Scanner scanner = new Scanner(in);

    @Override
    public void regist(RealEstate realEstate) {
        realEstateList.add(realEstate);
    }

    @Override
    public RealEstate getAddr(String address) {
        RealEstate realEstate = null;

        for(RealEstate tmp : realEstateList)
        {
            if(address.equals(tmp.getAddress()))
            {
                realEstate = tmp;
            }
        }

        return realEstate;
    }

    public RealEstate getEstateByType(String type) {
        RealEstate realEstate = null;

        if(Objects.equals(type, "매매"))
        {
            for (RealEstate estate : realEstateList) {
                if (estate.getInfo().equals("매매")) {
                    realEstate = estate;
                }
            }
        } else if (type.equals("월세"))
        {
            for (RealEstate estate : realEstateList) {
                if (estate.getInfo().equals("월세")) {
                    realEstate = estate;
                }
            }
        } else if (type.equals("전세"))
        {
            for (RealEstate estate : realEstateList) {
                if (estate.getInfo().equals("전세")) {
                    realEstate = estate;
                }
            }
        }

        return realEstate;
    }

    @Override
    public int delete(String address) {
        RealEstate realEstate = getAddr(address);

        for(int i = 0; i < realEstateList.size(); i++)
        {
            if(address.equals(realEstateList.get(i).getAddress()))
            {
                realEstateList.remove(realEstate);
            }
        }

        return 0;
    }

    @Override
    public int update(RealEstate realEstate) {
        int price;

        int i = listPosition(realEstate.getAddress());

        if(realEstateList.get(i) instanceof Charter)
        {
            out.println("전세 물건을 수정합니다.");
            out.print("| 전세 보증금 | ");
            price = scanner.nextInt();

            Charter charter = (Charter) realEstateList.get(i);
            charter.setDepositMoney(price);
            realEstateList.set(i, charter);

            return 1;

        } else if (realEstateList.get(i) instanceof MonthlyRent) {
            out.println("월세 물건을 수정합니다.");
            out.print("| 월 임대료 | ");
            price = scanner.nextInt();

            MonthlyRent monthlyRent = (MonthlyRent) realEstateList.get(i);
            monthlyRent.setMonthlyRent(price);
            realEstateList.set(i, monthlyRent);

            return 1;

        } else if (realEstateList.get(i) instanceof BuyingAndSell) {
            out.println("매매 물건을 수정합니다.");
            out.print("| 매매 가격 | ");
            price = scanner.nextInt();

            BuyingAndSell buyingAndSell = (BuyingAndSell) realEstateList.get(i);
            buyingAndSell.setPrice(price);
            realEstateList.set(i, buyingAndSell);

            return 1;
        }

        return 0;
    }

    @Override
    public List<RealEstate> selectAll() {
        return realEstateList;
    }

    public int listPosition(String address) {
        int no = -1;

        for(int i = 0; i < realEstateList.size(); i++)
        {
            if(address.equals(realEstateList.get(i).getAddress()))
            {
                return i;
            }
        }

        return no;
    }
}

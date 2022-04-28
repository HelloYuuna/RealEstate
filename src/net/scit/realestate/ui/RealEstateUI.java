package net.scit.realestate.ui;

import net.scit.realestate.service.RealEstateServiceImpl;
import net.scit.realestate.vo.BuyingAndSell;
import net.scit.realestate.vo.Charter;
import net.scit.realestate.vo.MonthlyRent;
import net.scit.realestate.vo.RealEstate;

import java.util.*;
import static java.lang.System.*;

/**
 * projectName     :RealEstate
 * fileName        :RealEstateUI
 * author          :yuna
 * since           :2022/04/25
 */
public class RealEstateUI {
    RealEstateServiceImpl service = new RealEstateServiceImpl();
    Scanner scanner = new Scanner(in);

    public RealEstateUI(){
        menu();
    }

    private void menu() {
        String select;

        while(true){
            showMenu();
            out.print("메뉴 번호 선택 > ");
            select = scanner.nextLine();

            switch (select){
                case "1":
                    input();
                    break;
                case "2":
                    search();
                    break;
                case "3":
                    update();
                    break;
                case "4":
                    delete();
                    break;
                case "5":
                    output();
                    break;
                case "9":
                    out.println("\t[ 프로그램 종료! ]\n");
                    return;
                default:
                    err.println("잘못된 입력입니다. 메뉴를 다시 입력해주세요!\n");
            }
        }
    }

    private void input() {
        String select;

        while(true) {
            inputSub();
            select = scanner.nextLine();
            switch (select) {
                case "1":
                    trade();
                    break;
                case "2":
                    charter();
                    break;
                case "3":
                    monthly();
                    break;
                case "4":
                    out.println("상위메뉴로\n");
                    return;
                default:
                    err.println("잘못된 선택입니다. 다시 선택해주세요!\n");
            }
        }

    }

    /**
     * 공통부분
     * @param realEstate : 주소 주거형태 크기 입력
     * @return realEstate
     */
    private RealEstate commonInput(RealEstate realEstate) {
        String address;
        String houseType;
        int size;

        out.print("주소 > ");
        address = scanner.nextLine();

        out.print("주거형태 > ");
        houseType = scanner.nextLine();

        out.print("크기 > ");
        size = scanner.nextInt();
        scanner.nextLine();

        realEstate.setAddress(address);
        realEstate.setHousetype(houseType);
        realEstate.setSize(size);

        return realEstate;
    }

    private void trade() {
        out.println("\t[ 매매 등록 ]");
        int price;

        BuyingAndSell buyingAndSell = (BuyingAndSell) commonInput(new BuyingAndSell());

        out.print("매매 가격 > ");
        price = scanner.nextInt();
        scanner.nextLine();

        buyingAndSell.setPrice(price);
        service.regist(buyingAndSell);

        out.println("\t[ 등록 완료! ]\n");
    }

    private void charter() {
        out.println("\t[ 전세 등록 ]");
        int price;

        Charter charter = (Charter) commonInput(new Charter());

        out.print("전세 보증금 > ");
        price = scanner.nextInt();
        scanner.nextLine();

        charter.setDepositMoney(price);
        service.regist(charter);

        out.println("\t[ 등록 완료! ]\n");
    }

    private void monthly() {
        out.println("\t[ 월세 등록 ]");
        int price;

        MonthlyRent monthlyRent = (MonthlyRent) commonInput(new MonthlyRent());

        out.print("월 임대료 > ");
        price = scanner.nextInt();
        scanner.nextLine();

        monthlyRent.setMonthlyRent(price);
        service.regist(monthlyRent);

        out.println("\t[ 등록 완료! ]\n");
    }

    private void inputSub() {
        out.println("---------------------------");
        out.println("\t부동산 매물 정보 등록");
        out.println("---------------------------");
        out.println("\t1. 매매");
        out.println("\t2. 전세");
        out.println("\t3. 월세");
        out.println("\t4. 상위메뉴");
        out.println("---------------------------");
        out.print("메뉴 번호 선택 > ");
    }

    private void search() {
        String select;
        searchSub();
        select = scanner.nextLine();
        switch(select)
        {
            case "0":
                searchAdd();
                break;
            case "1":
                searchTrad();
                break;
            case "2":
                searchChar();
                break;
            case "3":
                searchMonth();
                break;
            default:
                err.println("잘못된 선택입니다. 다시 선택해주세요");
        }

        out.println("\t[ 검색 완료! ]\n");
    }

    private void searchMonth() {
        String type = "월세";

        RealEstate realEstate = service.getEstateByType(type);

        out.println("\t[ 월세 리스트 ]");
        out.println(realEstate);
    }

    private void searchChar() {
        String type = "전세";

        RealEstate realEstate = service.getEstateByType(type);

        out.println("\t[ 전세 리스트 ]");
        out.println(realEstate);
    }

    private void searchTrad() {
        String type = "매매";

        RealEstate realEstate = service.getEstateByType(type);

        out.println("\t[ 매매 리스트 ]");
        out.println(realEstate);
    }

    private void searchAdd() {
        RealEstate realEstate;
        String address;

        out.print("주소 > ");
        address = scanner.nextLine();

        realEstate = service.getAddr(address);
        if(realEstate == null)
        {
            out.println("일치하는 주소가 없습니다.");
            return;
        }

        List<RealEstate> list = new ArrayList<>();
        list.add(realEstate);
        for(RealEstate tmp : list){
            out.println(tmp);
        }
    }

    private void searchSub() {
        out.println("---------------------------");
        out.println("\t부동산 중계 관리 시스템");
        out.println("---------------------------");
        out.println("\t0. 주소로   검색");
        out.println("\t1. 매매 물건 검색");
        out.println("\t2. 전세 물건 검색");
        out.println("\t3. 월세 물건 검색");
        out.println("---------------------------");
        out.print("메뉴 번호 선택 > ");

    }

    private void update() {
        String address;

        out.print("| 수정 물건의 주소 | ");
        address = scanner.nextLine();

        RealEstate estate = service.getAddr(address);
        if(estate == null)
        {
            out.println("해당 주소와 일치하는 데이터가 없습니다.");
            return;
        }

        int res = service.update(estate);
        if(res == 0)
        {
            out.println("수정에 실패했습니다.");
            return;
        }

        out.println("\t[ 수정 완료! ]");

    }

    private void delete() {
        String address;
        String answer;

        while (true) {
            out.print("| 삭제 물건의 주소 | ");
            address = scanner.nextLine();

            out.print("정말 삭제하시겠어요? y/n >");
            answer = scanner.nextLine();

            if (answer.equals("y")) {
                service.delete(address);
                out.println("\t[ 삭제 완료! ]");
                return;                                 //해당 물건 삭제 완료

            } else if (answer.equals("n")) {
                out.println("\t[ 삭제 취소! ]");
                return;
            }

            out.println("잘못 입력 하셨습니다. 처음부터 다시 진행해주세요.");
        }
    }

    private void output() {
        List<RealEstate> realEstateList = service.selectAll();

        for (RealEstate realEstate : realEstateList) {
            out.println(realEstate);
        }

        out.println();
    }

    private void showMenu() {
        out.println("---------------------------");
        out.println("\t부동산 중계 관리 시스템");
        out.println("---------------------------");
        out.println("\t1. 등록");
        out.println("\t2. 검색");
        out.println("\t3. 수정");
        out.println("\t4. 삭제(거래완료)");
        out.println("\t5. 전체출력");
        out.println("\t9. 종료");
        out.println("---------------------------");

    }
}
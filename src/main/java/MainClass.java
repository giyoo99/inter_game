import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("헬로 오징어 게임");
        GameDao dao = new GameDaoImpl();
        List<GameDto> list = dao.findAll();
        int i = 1;
        for (GameDto d : list) {
            System.out.println("번호: " + i++);
            System.out.println("아이디: " + d.getUserId());
            System.out.println("패스워드: " + d.getUserPw());
            System.out.println("이름: " + d.getName());
            System.out.println("구슬갯수: " + d.getGusl());
        }
        // 회원가입 -> 저장
        Scanner sc = new Scanner(System.in);
//        System.out.print("아이디입력: ");
//        String userId = sc.next();
//        System.out.print("패스워드입력: ");
//        String userPw = sc.next();
//        System.out.print("이름입력: ");
//        String name = sc.next();
//
//        GameDto dto = new GameDto();
//        dto.setUserId(userId);
//        dto.setUserPw(userPw);
//        dto.setName(name);
//
//        dao.save(dto);
        // 로그인 -> 아이디 패스워드 찾기
        System.out.print("아이디입력: ");
        String userId = sc.next();
        System.out.print("패스워드입력: ");
        String userPw = sc.next();
        GameDto dto = dao.findIdPw(userId, userPw);
        if (dto != null) {
            System.out.println(dto.getName() + "님 반갑습니다.");
            System.out.println("당신이 가지고 있는 구슬은 " + dto.getGusl() + "개 입니다.");
        } else {
            System.out.println("계정이 없습니다.");
            return;
        }
        // 구슬의 정보를 수정 -> 업데이트
        System.out.println("구슬 갯수 업데이트");
        System.out.print(dto.getName() + "님의 구슬 갯수 변경: ");
        int marble = sc.nextInt();
        dao.update(dto.getId(), marble);
        // 유저를 삭제 -> 삭제
        System.out.println("부정하게 구슬 갯수가 수정되었습니다.");
        System.out.println("계정삭제!! 당신은 이제 접속할 수 없습니다.");
        dao.delete(dto.getId());

//        GlobalVal val = new GlobalVal();
//        GlobalVal.MAX = 20;
//        System.out.println(GlobalVal.MAX);
    }
}
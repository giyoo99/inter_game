import java.awt.*;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("헬로 오징어 게임");
        GameDao dao = new GameDaoImpl();
        //  회원가입 -> 저장
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디 입력: ");
        String userId = sc.next();
        System.out.println("패스워드 입력: ");
        String userpW = sc.next();
        System.out.println("이름 입력: ");
        String name = sc.next();

        GameDto dto = new GameDto();
        dto.setUserId(userId);
        dto.setUserPw(userpW);
        dto.setName(name);

        dao.save(dto);
        //  로그인 -> 아이디 패스워드 찾기
        //  구슬의 정보를 수정 -> 업데이트
        //  유저를 삭제 -> 삭제
    }
}

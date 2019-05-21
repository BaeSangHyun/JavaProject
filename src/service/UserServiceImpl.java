package service;

import dao.Session;
import dao.UserDao;
import dao.UserDaoImpl;
import vo.UserVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserServiceImpl implements UserService{

    private static UserServiceImpl instance;

    private  UserServiceImpl(){}

    public static UserServiceImpl getInstance(){
        if(instance == null){
            instance = new UserServiceImpl();
        }
        return instance;
    }
    
    UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public void join() {
        Scanner s = new Scanner(System.in);

        System.out.print("아이디 : ");
        String id = s.nextLine();
        System.out.print("비밀번호 : ");
        String pwd = s.nextLine();
        System.out.print("이름 : ");
        String name = s.nextLine();

        UserVO user = new UserVO();
        user.setId(id);
        user.setPwd(pwd);
        user.setName(name);

        UserVO userCheck = userDao.selectUser("ID", user.getId());

        if(userCheck == null){
            userDao.insertUser(user);
            System.out.println("가입해주셔서 감사합니다.");
        } else {
            System.out.println("아이디가 중복되었습니다.");
        }
    }

    @Override
    public void login() {
        Scanner s = new Scanner(System.in);
        System.out.print("아이디 : ");
        String id = s.nextLine();
        System.out.print("비밀번호 : ");
        String pwd = s.nextLine();

        HashMap<String,String> param = new HashMap<String, String>();
        param.put("ID", id);
        param.put("PASSWORD", pwd);

        UserVO user = userDao.selectUser(param);

        if(user == null){
            System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
        } else {
            Session.loginUser = user;
            System.out.println("로그인 성공!!");
            System.out.println(user.getName() + "님 환영합니다.");
        }
    }

    @Override
    public void userList() {
        ArrayList<UserVO> userList = userDao.selectUserList();

        System.out.println("---------------------------------------");
        System.out.println("번호\t아이디\t이름");
        System.out.println("---------------------------------------");
        for(int i = 0; i < userList.size(); i++){
            UserVO user = userList.get(i);
            System.out.println(i + 1 + "\t" + user.getId() + "\t" + user.getName());
        }
        System.out.println("---------------------------------------");
    }
}

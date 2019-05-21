package dao;

import data.Database;
import vo.UserVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private static UserDaoImpl instance;

    private UserDaoImpl(){}

    public static UserDaoImpl getInstance(){
        if(instance == null){
            instance = new UserDaoImpl();
        }
        return instance;
    }

    Database db = Database.getInstance();

    @Override
    public UserVO selectUser(String key, String value) {
        for(int i = 0; i < db.tb_user.size(); i++){
            UserVO user = db.tb_user.get(i);

            if(key.equals("ID")){
                if(user.getId().equals(value)){
                    return user;
                }
            }
        }
        return null;
    }

    @Override
    public UserVO selectUser(HashMap<String, String> param) {
        UserVO rtnUser = null;
        for(int i = 0; i < db.tb_user.size(); i++){
            UserVO user = db.tb_user.get(i);
            boolean flag = true;

            Iterator<String> itr = param.keySet().iterator();
            while (itr.hasNext()){
                String key = itr.next();
                String value = param.get(key);
                if(key.equals("ID")){
                    if(!user.getId().equals(value)){
                        flag = false;
                    }
                } else if(key.equals("PASSWORD")){
                    if(!user.getPwd().equals(value)){
                        flag = false;
                    }
                } else if(key.equals("NAME")){
                    if(!user.getName().equals(value)){
                        flag = false;
                    }
                }
            }
            if(flag){
                rtnUser = user;
            }
        }
        return rtnUser;
    }

    @Override
    public void insertUser(UserVO user) {
        db.tb_user.add(user);
    }

    @Override
    public ArrayList<UserVO> selectUserList() {
        return db.tb_user;
    }
}

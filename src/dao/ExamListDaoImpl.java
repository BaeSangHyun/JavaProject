package dao;

import data.ExamListDB;
import vo.ExamInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ExamListDaoImpl implements ExamListDao {
    private static ExamListDaoImpl instance;
    private ExamListDaoImpl(){}
    public static ExamListDaoImpl getInstance(){
        if(instance == null){
            instance = new ExamListDaoImpl();
        }
        return instance;
    }


    @Override
    public HashMap<String, HashMap<String, ArrayList<ExamInfo>>> getExamList() {
        ExamListDB examListDB = ExamListDB.getInstance();
        HashMap<String, HashMap<String, ArrayList<ExamInfo>>> examDB = examListDB.examDB;
        return examDB;
    }

    @Override
    public HashMap<String, ArrayList<ExamInfo>> getExamEvent(String key) {
        ExamListDB examListDB = ExamListDB.getInstance();
        HashMap<String, ArrayList<ExamInfo>> examEvent = examListDB.examDB.get(key);
        return examEvent;
    }

    @Override
    public ArrayList<ExamInfo> getExamDetail(String key) {
        ExamListDB examListDB = ExamListDB.getInstance();
       ArrayList<ExamInfo> examEvent = examListDB.examDB.get(key).get(key);
        return examEvent;
    }
}

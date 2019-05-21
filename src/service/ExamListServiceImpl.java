package service;

import dao.ExamListDao;
import dao.ExamListDaoImpl;
import vo.ExamInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ExamListServiceImpl implements ExamListService {
    private static ExamListServiceImpl instance;

    private ExamListServiceImpl(){}

    public static ExamListServiceImpl getInstance(){
        if(instance == null){
            instance = new ExamListServiceImpl();
        }
        return instance;
    }

    //시행종목명 저장
    private ArrayList<String> examName;
    private ArrayList<String> examEventName;

    String keyName;
    String detailKeyName;

    @Override
    public void getExamList() {
        int i = 1;
        examName = new ArrayList<String>();
        ExamListDao examListDao = ExamListDaoImpl.getInstance();
        HashMap<String, HashMap<String, ArrayList<ExamInfo>>> examList = examListDao.getExamList();
        Iterator<String> itr = examList.keySet().iterator();
        System.out.println("---------- 국가기술 자격 시행 종목 -----------");
        while(itr.hasNext()){
            String key = itr.next();
            System.out.println(i + ". " + key);
            examName.add(key);
            i++;
        }
    }

    @Override
    public void getExamList(int num){
        int i = 1;
        examEventName = new ArrayList<String>();
        ExamListDao examListDao = ExamListDaoImpl.getInstance();
        keyName = examName.get(num-1);
        HashMap<String, ArrayList<ExamInfo>> examList = examListDao.getExamEvent(keyName);
        Iterator<String> itr = examList.keySet().iterator();
        System.out.println("-------------- " + keyName + " ---------------");
        while (itr.hasNext()){
            String key = itr.next();
            System.out.println(i + ". " + key);
            examEventName.add(key);
            i++;
        }
    }

    @Override
    public void getExamDetail(int num) {
        ExamListDao examListDao = ExamListDaoImpl.getInstance();
        detailKeyName = examEventName.get(num-1);
        ArrayList<ExamInfo> examList = examListDao.getExamEvent(keyName).get(detailKeyName);
        System.out.println("-------------- " + detailKeyName + " ---------------");
        System.out.println("\t\t회차\t\t필기원서접수\t필기시험\t\t필기합격");
        for (int i = 0; i < examList.size(); i++){
            System.out.println(i+1 + ". " + examList.get(i).getExamNum() + "\t" + examList.get(i).getApplyDate()  + "\t" + examList.get(i).getWriteDate() + "\t" + examList.get(i).getSuccessDate());
        }
    }
}

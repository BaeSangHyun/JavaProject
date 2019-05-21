package data;

import vo.ExamInfo;

import java.util.ArrayList;
import java.util.HashMap;

public class ExamListDB {
    private static ExamListDB instance;

    private ExamListDB(){}

    public static ExamListDB getInstance(){
        if(instance == null){
            instance = new ExamListDB();
        }
        return instance;
    }

    //시험목록 테이블
    public HashMap<String, HashMap<String , ArrayList<ExamInfo>>> examDB = new HashMap<String, HashMap<String , ArrayList<ExamInfo>>>();

    {
        HashMap<String, ArrayList<ExamInfo>> examHash = new HashMap<String, ArrayList<ExamInfo>>();
        ArrayList<ExamInfo> e1_1 = new ArrayList<ExamInfo>();
        ExamInfo exam1 = new ExamInfo();
        exam1.setExamNum("기중기1회차");
        exam1.setApplyDate("20190530");
        exam1.setWriteDate("20190605");
        exam1.setSuccessDate("20190630");
        e1_1.add(exam1);
        ExamInfo exam1_1 = new ExamInfo();
        exam1_1.setExamNum("기중기2회차");
        exam1_1.setApplyDate("20190530");
        exam1_1.setWriteDate("20190605");
        exam1_1.setSuccessDate("20190630");
        e1_1.add(exam1_1);
        
        examHash.put("기중기운전기능사", e1_1);

        ArrayList<ExamInfo> e1_2 = new ArrayList<ExamInfo>();
        ExamInfo exam1_1_1 = new ExamInfo();
        exam1_1_1.setExamNum("굴삭기1회차");
        exam1_1_1.setApplyDate("20190530");
        exam1_1_1.setWriteDate("20190605");
        exam1_1_1.setSuccessDate("20190630");
        e1_2.add(exam1_1_1);
        ExamInfo exam1_1_2 = new ExamInfo();
        exam1_1_2.setExamNum("굴삭기2회차");
        exam1_1_2.setApplyDate("20190530");
        exam1_1_2.setWriteDate("20190605");
        exam1_1_2.setSuccessDate("20190630");
        e1_2.add(exam1_1_2);

        examHash.put("굴삭기운전기능사", e1_2);

        examDB.put("건설기계운전", examHash);


        HashMap<String, ArrayList<ExamInfo>> examHash2 = new HashMap<String, ArrayList<ExamInfo>>();
        ArrayList<ExamInfo> e2_1 = new ArrayList<ExamInfo>();
        ExamInfo exam2 = new ExamInfo();
        exam2.setExamNum("배관1회차");
        exam2.setApplyDate("20190530");
        exam2.setWriteDate("20190605");
        exam2.setSuccessDate("20190630");
        e2_1.add(exam2);
        examHash2.put("배관기능사", e2_1);
        examDB.put("건설배관", examHash2);


    }
}

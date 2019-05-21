package data;

import vo.ExamInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ExamDB {

    public static void main(String[] args) {
//        DB d = DB.;
        DB d = new DB();
        HashMap<String, ArrayList<ExamInfo>> exam = d.examDB.get("건설기계운전");
        ArrayList<ExamInfo> e = exam.get("기중기운전기능사");
//        System.out.println(d.examDB.get("건설기계운전"));
//        Iterator<String> it = exam.keySet().iterator();
//        while(it.hasNext()){
//            String key = it.next();
//            System.out.println(key);
//        }
        Iterator<String> itr = d.examDB.keySet().iterator();
        while(itr.hasNext()){
            String key = itr.next();
            System.out.println(key);
            Iterator<String> itr2 = d.examDB.get(key).keySet().iterator();
            while(itr2.hasNext()){
                String key2 = itr2.next();
                System.out.println(key2);
            }

//            System.out.println(d.examDB.get(key));
        }
//        System.out.println(exam.get("기중기운전기능사"));
        for(int i = 0; i < e.size(); i++){
            System.out.println(e.get(i).getExamNum() + " | " + e.get(i).getSuccessDate());
        }
    }

}

class DB{
//        private static DB instance;
//
//    private DB(){}
//
//    private static DB getInstance(){
//        if(instance == null){
//            instance = new ExamDB();
//        }
//        return instance;
//    }
    HashMap<String, HashMap<String , ArrayList<ExamInfo>>> examDB = new HashMap<String, HashMap<String , ArrayList<ExamInfo>>>();

    {
        HashMap<String, ArrayList<ExamInfo>> examHash = new HashMap<String, ArrayList<ExamInfo>>();
        ArrayList<ExamInfo> e = new ArrayList<ExamInfo>();
        ExamInfo exam = new ExamInfo();
        exam.setExamNum("20190521");
        exam.setApplyDate("20190530");
        exam.setWriteDate("20190605");
        exam.setSuccessDate("20190630");
        e.add(exam);
        examHash.put("기중기운전기능사", e);
        examDB.put("건설기계운전", examHash);


        HashMap<String, ArrayList<ExamInfo>> examHash2 = new HashMap<String, ArrayList<ExamInfo>>();
        ArrayList<ExamInfo> e2 = new ArrayList<ExamInfo>();
        exam.setExamNum("20190521");
        exam.setApplyDate("20190530");
        exam.setWriteDate("20190605");
        exam.setSuccessDate("20190630");
        e2.add(exam);
        examHash2.put("배관기능사", e2);
        examDB.put("건설배관", examHash2);


//        System.out.println(examDB.get("건설기계운전"));
    }
}

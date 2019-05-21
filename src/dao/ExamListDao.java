package dao;

import vo.ExamInfo;

import java.util.ArrayList;
import java.util.HashMap;

public interface ExamListDao {
    //시험 목록 조회
    HashMap<String, HashMap<String , ArrayList<ExamInfo>>> getExamList();

    //시험 자격명 조회
    HashMap<String , ArrayList<ExamInfo>> getExamEvent(String key);

    ArrayList<ExamInfo> getExamDetail(String key);
}

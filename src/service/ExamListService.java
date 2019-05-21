package service;

public interface ExamListService {
    //산업기사 시행종목
    void getExamList();

    //시행종목 클릭시 자격명 출력
    void getExamList(int num);

    void getExamDetail(int num);
}

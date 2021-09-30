package com.example.MiniProjectUniversity.service;

import com.example.MiniProjectUniversity.dto.ExamRequestDto;
import com.example.MiniProjectUniversity.dto.ExamResponseDto;
import com.example.MiniProjectUniversity.model.*;
import com.example.MiniProjectUniversity.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class ExamService {

    @Autowired
    private ExamRepository repository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private ExamLevelRepository examLevelRepository;

    public List<Exam> findAll(){
        List<Exam> examList = repository.findAllExam();
        return examList;
    }

    public List<ExamResponseDto> findAllExam(){
        List<ExamResponseDto> responseDtos = new ArrayList<>();
        return buildResponseFromExam(responseDtos);
    }

    private List<ExamResponseDto> buildResponseFromExam(
            List<ExamResponseDto> responseDtos) {
        List<Exam> list = repository.findAllExam();
        for (Exam exam: list) {
            ExamResponseDto dto = new ExamResponseDto();
            dto.setExamCode(exam.getExamCode());
            dto.setSubject(exam.getSubject().getNameSubject());
            dto.setStudent(exam.getStudent().getFullName());
            dto.setLecturer(exam.getLecturer().getFullName());
            dto.setSemester(exam.getSubject().getSemester());
            dto.setExamLevel(exam.getExamLevel().getExamLevel());
            dto.setScore(exam.getScore());
            dto.setDate(exam.getDate());
            responseDtos.add(dto);
        }
        return responseDtos;
    }

    @Transactional(rollbackFor = Throwable.class)
    public Exam create(ExamRequestDto examRequestDto){
        Exam dataExam = insertDataExam(examRequestDto);
        repository.save(dataExam);
        return dataExam;
    }

    @Transactional(rollbackFor = Throwable.class)
    public Exam update(ExamRequestDto examRequestDto){
        Exam exam = updateDataExam(examRequestDto);
        return repository.save(exam);
    }

    public ExamResponseDto findById(String id){
        Optional<Exam> optional = repository.findById(id);
        ExamResponseDto dto = buildResponseFromExamFindById(optional);
        return dto;
    }

    private ExamResponseDto buildResponseFromExamFindById(Optional<Exam> optional) {
        ExamResponseDto dto = new ExamResponseDto();
        dto.setExamCode(optional.get().getExamCode());
        dto.setSubject(optional.get().getSubject().getCodeSubject());
        dto.setStudent(optional.get().getStudent().getIdStudent());
        dto.setLecturer(optional.get().getLecturer().getIdLecturer());
        dto.setExamLevel(optional.get().getExamLevel().getExamLevelCode());
        dto.setScore(optional.get().getScore());
        dto.setDate(optional.get().getDate());
        return dto;
    }

    private Exam updateDataExam(ExamRequestDto examRequestDto) {
        Exam exam = new Exam();
        exam.setExamCode(examRequestDto.getExamCode());
        exam.setScore(examRequestDto.getScore());
        exam.setDate(date());

        Subject subject = checkIdSubject(examRequestDto);
        exam.setSubject(subject);

        Student student = checkIdStudent(examRequestDto);
        exam.setStudent(student);

        Lecturer lecturer = checkIdLecturer(examRequestDto);
        exam.setLecturer(lecturer);

        ExamLevel level = checkExamLevelCode(examRequestDto);
        exam.setExamLevel(level);
        return exam;
    }

    private Exam insertDataExam(ExamRequestDto examRequestDto){
        Exam exam = new Exam();
        if (examRequestDto.getExamCode()==null){
            exam.setExamCode(String.valueOf(randomNumber()));
            exam.setScore(examRequestDto.getScore());
            exam.setDate(date());

            Subject subject = checkIdSubject(examRequestDto);
            exam.setSubject(subject);

            Student student = checkIdStudent(examRequestDto);
            exam.setStudent(student);

            Lecturer lecturer = checkIdLecturer(examRequestDto);
            exam.setLecturer(lecturer);

            ExamLevel examLevel = checkExamLevelCode(examRequestDto);
            exam.setExamLevel(examLevel);
        }
        return exam;
    }

    private ExamLevel checkExamLevelCode(ExamRequestDto examRequestDto) {
        ExamLevel examLevel = new ExamLevel();
        List<ExamLevel> examLevels = examLevelRepository.findAll();
        for (ExamLevel level : examLevels){
            if (level.getExamLevelCode().equals(examRequestDto.getExamLevel())){
                examLevel = insertExamLevel(level);
            }
        }
        return examLevel;
    }

    private ExamLevel insertExamLevel(ExamLevel level) {
        ExamLevel examLevel = new ExamLevel();
        examLevel.setExamLevelCode(level.getExamLevelCode());
        examLevel.setExamLevel(level.getExamLevel());
        return examLevel;
    }

    private Lecturer checkIdLecturer(ExamRequestDto examRequestDto) {
        Lecturer lecturer = new Lecturer();
        List<Lecturer> list = lecturerRepository.findAll();
        for (Lecturer lecturer1: list){
            if (lecturer1.getIdLecturer().equals(examRequestDto.getLecturer())){
                lecturer = insertLecturer(lecturer1);
            }
        }
        return lecturer;
    }

    private Lecturer insertLecturer(Lecturer lecturer1) {
        Lecturer lecturer = new Lecturer();
        lecturer.setIdLecturer(lecturer1.getIdLecturer());
        lecturer.setLecturerIdNumber(lecturer1.getLecturerIdNumber());
        lecturer.setFullName(lecturer1.getFullName());
        lecturer.setAddress(lecturer1.getAddress());
        lecturer.setEmail(lecturer1.getEmail());
        lecturer.setPhone(lecturer1.getPhone());
        return lecturer;
    }

    private Student checkIdStudent(ExamRequestDto examRequestDto) {
        Student student = new Student();
        List<Student> students = studentRepository.findAll();
        for (Student student1 : students){
            if (student1.getIdStudent().equals(examRequestDto.getStudent())){
                student = insertStudent(student1);
            }
        }
        return student;
    }

    private Student insertStudent(Student student1) {
        Student student = new Student();
        student.setIdStudent(student1.getIdStudent());
        student.setStudentIdNumber(student1.getStudentIdNumber());
        student.setFullName(student1.getFullName());
        student.setEmail(student1.getEmail());
        student.setAddress(student1.getAddress());
        student.setStudyProgram(student1.getStudyProgram());
        student.setPhone(student1.getPhone());
        return student;
    }

    private Subject checkIdSubject(ExamRequestDto examRequestDto) {
        Subject subject = new Subject();
        List<Subject> subjects = subjectRepository.findAll();
        for (Subject subject1:subjects){
            if (subject1.getCodeSubject().equals(examRequestDto.getSubject())){
                subject = insertSubject(subject1);
            }
        }
        return subject;
    }

    private Subject insertSubject(Subject subject) {
        Subject subject1 = new  Subject();
        subject1.setCodeSubject(subject.getCodeSubject());
        subject1.setNameSubject(subject.getNameSubject());
        subject1.setSks(subject.getSks());
        subject1.setSemester(subject.getSemester());

        return subject1;
    }

    private int randomNumber() {
        Random rnd = new Random();
        int number = rnd.nextInt(99999999);
        int k = Integer.parseInt(String.format("%08d", number));
        return k;
    }

    private Date date(){
        /*DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);*/
        Date date = new Date();
        long longDate = (date.getTime() + TimeUnit.DAYS.toMillis(30));
        date = new Date(longDate);
        return date;
    }

    @Transactional(rollbackFor = Throwable.class)
    public Object delete(String id) {
        repository.deleteById(id);
        return "suksessss";
    }

}
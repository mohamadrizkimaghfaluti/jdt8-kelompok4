package com.example.MiniProjectUniversity.service;

import com.example.MiniProjectUniversity.model.Lecturer;
import com.example.MiniProjectUniversity.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LecturerService {

    @Autowired
    private LecturerRepository repository;

    @Transactional(rollbackFor = Throwable.class)
    public Boolean createLecturer(Lecturer lecturer){
        Lecturer lecturer1 = checkLecturerIdNumber(lecturer);
        if (lecturer1 == null){
            return false;
        }
        repository.save(lecturer1);
        return true;
    }

    @Transactional(readOnly = true)
    public List<Lecturer> findAllLecturer() { return repository.findAll();}

    @Transactional(rollbackFor = Throwable.class)
    public Object deleteLecturer(String id){
        repository.deleteById(id);
        return "berhasil dihapus";
    }

    @Transactional(readOnly = true)
    public Optional findLecturerById(String id){ return repository.findById(id);}

    @Transactional(rollbackFor = Throwable.class)
    public Lecturer updateLecturer(Lecturer lecturer) { return repository.save(lecturer);}

    private Lecturer checkLecturerIdNumber(Lecturer lecturer) {
        List<Lecturer> list = repository.findAll();
        for (Lecturer lct : list){
            if (lct.getLecturerIdNumber().equals(lecturer.getLecturerIdNumber())){
                return null;
            }
        }
        Lecturer dataLecturer = insertLecturerFromRequest(lecturer);
        return dataLecturer;
    }

    private Lecturer insertLecturerFromRequest(Lecturer lecturer) {
        Lecturer lecturer1 = new Lecturer();
        if (lecturer.getIdLecturer() == null || lecturer.getIdLecturer().equals("")) {
            String id = UUID.randomUUID().toString();

            lecturer1.setIdLecturer(id);
            lecturer1.setLecturerIdNumber(lecturer.getLecturerIdNumber());
            lecturer1.setFullName(lecturer.getFullName());
            lecturer1.setAddress(lecturer.getAddress());
            lecturer1.setEmail(lecturer.getEmail());
            lecturer1.setPhone(lecturer.getPhone());
        }
        return lecturer1;
    }
}

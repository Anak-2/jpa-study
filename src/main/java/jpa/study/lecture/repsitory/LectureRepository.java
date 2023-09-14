package jpa.study.lecture.repsitory;

import jpa.study.lecture.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

    @Query("select l from Lecture l where l.id in (:ids)")
    List<Lecture> findLecturesByLectureIds(
            @Param("ids")
            List<String> lectureIds
    );

    @Query("select l from Lecture l where l.id not in (:ids)")
    List<Lecture> findLecturesByLectureIdsNot(
            @Param("ids")
            List<String> lectureIds
    );
}

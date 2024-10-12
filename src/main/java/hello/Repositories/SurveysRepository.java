package hello.Repositories;

import hello.Models.Surveys;
import org.springframework.data.repository.CrudRepository;

public interface SurveysRepository extends CrudRepository<Surveys,Integer> {
    Iterable<Surveys> findByYearAndMonth(Integer year, Integer month);
    Iterable<Surveys> findByYearAndMonthAndQ1(Integer year, Integer month, Integer Q1);
    Iterable<Surveys> findByYearAndMonthAndQ2(Integer year, Integer month, Integer Q2);
    Iterable<Surveys> findByYearAndMonthAndQ3(Integer year, Integer month, Integer Q3);
    Iterable<Surveys> findByYearAndMonthAndQ4(Integer year, Integer month, Integer Q4);
}

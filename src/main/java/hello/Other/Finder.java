package hello.Other;

import hello.Models.Surveys;
import hello.Repositories.SurveysRepository;

public class Finder {
    public static Iterable<Surveys> questionFinder(SurveysRepository surveysRepository, Integer question, Integer answer, Integer year, Integer month){
        switch (question){
            case 1: {
                return surveysRepository.findByYearAndMonthAndQ1(year, month, answer);
            }
            case 2: {
                return surveysRepository.findByYearAndMonthAndQ2(year, month, answer);
            }
            case 3:{
                return surveysRepository.findByYearAndMonthAndQ3(year, month, answer);
            }
            case 4:{
                return surveysRepository.findByYearAndMonthAndQ4(year, month, answer);
            }
            default:{
                return null;
            }
        }
    }
}

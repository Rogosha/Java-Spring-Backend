package hello.Other;

import hello.Models.Surveys;

import java.util.HashMap;
import java.util.Map;

public class Counter {
    private int countOfMale;
    private int countOfFemale;
    private int countOfZoomers;
    private int countOfBoomers;
    private int countOfMillenials;
    private int countOfBabyBoomers;
    private int countOfEconomy;
    private int countOfBusiness;
    private int countOfFirst;

    public Counter(Iterable<Surveys> surveys) {
        Map<String, Integer> destinationAirport = new HashMap<>();
        for (Surveys survey : surveys ){
            if (survey.getGender()) {
                countOfMale++;
            }
            if ((survey.getAge() > 17) && (survey.getAge() < 25)) {
                countOfZoomers++;
            } else if ((survey.getAge() > 24) && (survey.getAge() < 40)) {
                countOfBoomers++;
            } else if ((survey.getAge() > 39) && (survey.getAge() < 60)) {
                countOfMillenials++;
            } else if ((survey.getAge() > 59)) {
                countOfBabyBoomers++;
            }
            if (survey.getCabinType().getName().equals("Economy")){
                countOfEconomy++;
            }
            if (survey.getCabinType().getName().equals("Business")){
                countOfBusiness++;
            }
            if (survey.getCabinType().getName().equals("First")){
                countOfFirst++;
            }
            destinationAirport.put( survey.getDepartureAirport().getIATACode(),
                                    destinationAirport.getOrDefault(survey.getDepartureAirport()
                                                                          .getIATACode(),0) + 1);
        }
    }

    public void count(Iterable<Surveys> surveys){
        for (Surveys survey : surveys ){
            Map<String, Integer> destinationAirport = new HashMap<>();
            if (survey.getGender()) {
                countOfMale++;
            }
            if ((survey.getAge() > 17) && (survey.getAge() < 25)) {
                countOfZoomers++;
            } else if ((survey.getAge() > 24) && (survey.getAge() < 40)) {
                countOfBoomers++;
            } else if ((survey.getAge() > 39) && (survey.getAge() < 60)) {
                countOfMillenials++;
            } else if ((survey.getAge() > 59)) {
                countOfBabyBoomers++;
            }
            if (survey.getCabinType().getName().equals("Economy")){
                countOfEconomy++;
            }
            if (survey.getCabinType().getName().equals("Business")){
                countOfBusiness++;
            }
            if (survey.getCabinType().getName().equals("First")){
                countOfFirst++;
            }
            destinationAirport.put( survey.getDepartureAirport().getIATACode(),
                    destinationAirport.getOrDefault(survey.getDepartureAirport()
                            .getIATACode(),0) + 1);
        }
    }
}

package hello.Controllers;

import hello.Models.DTOs.SurveysDTO;
import hello.Models.Surveys;
import hello.Other.Finder;
import hello.Repositories.AirportsRepository;
import hello.Repositories.CabinTypesRepository;
import hello.Repositories.SurveysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class SurveysController {
    @Autowired
    private SurveysRepository surveysRepository;

    @Autowired
    private AirportsRepository airportsRepository;

    @Autowired
    private CabinTypesRepository cabinTypesRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/surveys")
    public Iterable<Surveys> getSurveys() {
        return surveysRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/surveys/{id}")
    public Surveys getSurvey(@PathVariable(value = "id") int id) {
        try {
            return surveysRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/surveys/reports")
    public Map<String, Integer> getSurveyByDateAndYear(@RequestBody SurveysDTO date) {
        Iterable<Surveys> surveys = surveysRepository.findByYearAndMonth(date.getYear(), date.getMonth());
        Map<String, Integer> variableOfAnswer = new HashMap<>();
        for (Surveys survey : surveys ){
            if (survey.getGender()) {
                variableOfAnswer.put("Male",variableOfAnswer.getOrDefault("Male",0) + 1);
            } else{
                variableOfAnswer.put("Female",variableOfAnswer.getOrDefault("Female",0) + 1);
            }

            if ((survey.getAge() > 17) && (survey.getAge() < 25)) {
                variableOfAnswer.put("18-24",variableOfAnswer.getOrDefault("18-24",0) + 1);
            } else if ((survey.getAge() > 24) && (survey.getAge() < 40)) {
                variableOfAnswer.put("25-39",variableOfAnswer.getOrDefault("25-39",0) + 1);
            } else if ((survey.getAge() > 39) && (survey.getAge() < 60)) {
                variableOfAnswer.put("40-59",variableOfAnswer.getOrDefault("40-59",0) + 1);
            } else if ((survey.getAge() > 59)) {
                variableOfAnswer.put("60+",variableOfAnswer.getOrDefault("60+",0) + 1);
            }

            if (survey.getCabinType().getName().equals("Economy")){
                variableOfAnswer.put("Economy",variableOfAnswer.getOrDefault("Economy",0) + 1);
            } else if (survey.getCabinType().getName().equals("Business")){
                variableOfAnswer.put("Business",variableOfAnswer.getOrDefault("Business",0) + 1);
            } else if (survey.getCabinType().getName().equals("First")){
                variableOfAnswer.put("FirstClass",variableOfAnswer.getOrDefault("FirstClass",0) + 1);
            }

            variableOfAnswer.put(   survey.getDepartureAirport().getIATACode(),
                    variableOfAnswer.getOrDefault(survey.getDepartureAirport()
                            .getIATACode(),0) + 1);
        }
        return variableOfAnswer;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/surveys/fullreports")
    public Map<Integer, Map<Integer, Map<String, Integer>>> getSurveyByDateAndYearFull(@RequestBody SurveysDTO date){

        Map<Integer, Map<Integer, Map<String, Integer>>> report = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            Map<Integer, Map<String, Integer>> question = new HashMap<>();
            for (int j = 1; j < 8; j++) {
                Iterable<Surveys> surveys = Finder.questionFinder(surveysRepository, i+1, j, date.getYear(), date.getMonth());
                Map<String, Integer> variableOfAnswer = new HashMap<>();
                for (Surveys survey : surveys ){
                    if (survey.getGender()) {
                        variableOfAnswer.put("Male",variableOfAnswer.getOrDefault("Male",0) + 1);
                    } else if (!survey.getGender()){
                        variableOfAnswer.put("Female",variableOfAnswer.getOrDefault("Female",0) + 1);
                    }

                    if ((survey.getAge() > 17) && (survey.getAge() < 25)) {
                        variableOfAnswer.put("18-24",variableOfAnswer.getOrDefault("18-24",0) + 1);
                    } else if ((survey.getAge() > 24) && (survey.getAge() < 40)) {
                        variableOfAnswer.put("25-39",variableOfAnswer.getOrDefault("25-39",0) + 1);
                    } else if ((survey.getAge() > 39) && (survey.getAge() < 60)) {
                        variableOfAnswer.put("40-59",variableOfAnswer.getOrDefault("40-59",0) + 1);
                    } else if ((survey.getAge() > 59)) {
                        variableOfAnswer.put("60+",variableOfAnswer.getOrDefault("60+",0) + 1);
                    }

                    if (survey.getCabinType().getName().equals("Economy")){
                        variableOfAnswer.put("Economy",variableOfAnswer.getOrDefault("Economy",0) + 1);
                    } else if (survey.getCabinType().getName().equals("Business")){
                        variableOfAnswer.put("Business",variableOfAnswer.getOrDefault("Business",0) + 1);
                    } else if (survey.getCabinType().getName().equals("First")){
                        variableOfAnswer.put("FirstClass",variableOfAnswer.getOrDefault("FirstClass",0) + 1);
                    }

                    variableOfAnswer.put(   survey.getDepartureAirport().getIATACode(),
                                            variableOfAnswer.getOrDefault(survey.getDepartureAirport()
                                                                                .getIATACode(),0) + 1);
                }
                question.put(j, variableOfAnswer);
            }
            report.put(1, question);
        }
        return report;
    }



    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/surveys")
    public Surveys postSurveys(@RequestBody Iterable<SurveysDTO> surveysDTO) {
        for (SurveysDTO surveyDTO : surveysDTO) {
            Surveys survey = new Surveys();
            if (surveyDTO.getMonth() != null){
                survey.setMonth(surveyDTO.getMonth());
            }
            if (surveyDTO.getYear() != null){
                survey.setYear(surveyDTO.getYear());
            }
            if (airportsRepository.findByIATACode(surveyDTO.getDepartureAirport()).isPresent()){
                survey.setDepartureAirport(airportsRepository.findByIATACode(surveyDTO.getDepartureAirport()).orElseThrow());
            }
            if (airportsRepository.findByIATACode(surveyDTO.getArrivalAirport()).isPresent()){
                survey.setArrivalAirport(airportsRepository.findByIATACode(surveyDTO.getArrivalAirport()).orElseThrow());
            }
            if (surveyDTO.getAge() != null){
                survey.setAge(surveyDTO.getAge());
            }
            if (surveyDTO.getGender() != null){
                if (surveyDTO.getGender()){
                    survey.setGender(true);
                } else
                    survey.setGender(false);
            }
            if (cabinTypesRepository.findByName(surveyDTO.getCabinType()).isPresent()){
                survey.setCabinType(cabinTypesRepository.findByName(surveyDTO.getCabinType()).orElseThrow());
            }
            if (surveyDTO.getQ1() != null) {
                survey.setQ1(surveyDTO.getQ1());
            }
            if (surveyDTO.getQ2() != null) {
                survey.setQ1(surveyDTO.getQ2());
            }
            if (surveyDTO.getQ3() != null) {
                survey.setQ1(surveyDTO.getQ3());
            }
            if (surveyDTO.getQ4() != null) {
                survey.setQ1(surveyDTO.getQ4());
            }
            surveysRepository.save(survey);
        }
        return new Surveys();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,
            RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/surveys")
    public Surveys putSurveys(@RequestBody SurveysDTO surveyDTO) {
        try {
            Surveys survey = surveysRepository.findById(surveyDTO.getId()).orElseThrow();
            if (surveyDTO.getMonth() != null){
                survey.setMonth(surveyDTO.getMonth());
            }
            if (surveyDTO.getYear() != null){
                survey.setYear(surveyDTO.getYear());
            }
            if (airportsRepository.findByIATACode(surveyDTO.getDepartureAirport()).isPresent()){
                survey.setDepartureAirport(airportsRepository.findByIATACode(surveyDTO.getDepartureAirport()).orElseThrow());
            }
            if (airportsRepository.findByIATACode(surveyDTO.getArrivalAirport()).isPresent()){
                survey.setArrivalAirport(airportsRepository.findByIATACode(surveyDTO.getArrivalAirport()).orElseThrow());
            }
            if (surveyDTO.getAge() != null){
                survey.setAge(surveyDTO.getAge());
            }
            if (surveyDTO.getGender() != null){
                survey.setGender(surveyDTO.getGender());
            }
            if (cabinTypesRepository.findByName(surveyDTO.getCabinType()).isPresent()){
                survey.setCabinType(cabinTypesRepository.findByName(surveyDTO.getCabinType()).orElseThrow());
            }
            if (surveyDTO.getQ1() != null) {
                survey.setQ1(surveyDTO.getQ1());
            }
            if (surveyDTO.getQ2() != null) {
                survey.setQ1(surveyDTO.getQ2());
            }
            if (surveyDTO.getQ3() != null) {
                survey.setQ1(surveyDTO.getQ3());
            }
            if (surveyDTO.getQ4() != null) {
                survey.setQ1(surveyDTO.getQ4());
            }
            surveysRepository.save(survey);
            return survey;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/surveys/{id}")
    public Surveys deleteOffice(@PathVariable(value = "id") int id) {
        try {
            Surveys surveys = surveysRepository.findById(id).orElseThrow();
            surveysRepository.delete(surveys);
            return surveys;
        } catch (Exception e) {
            return null;
        }
    }

}

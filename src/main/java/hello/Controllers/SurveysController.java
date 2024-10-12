package hello.Controllers;

import hello.Models.DTOs.SurveysDTO;
import hello.Models.Surveys;
import hello.Other.Counter;
import hello.Other.FullCounter;
import hello.Repositories.AirportsRepository;
import hello.Repositories.CabinTypesRepository;
import hello.Repositories.SurveysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
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
    @GetMapping("/surveys/reports")
    public Counter getSurveyByDateAndYear(@RequestBody SurveysDTO date) {
        Iterable<Surveys> surveys = surveysRepository.findByYearAndMonth(date.getYear(), date.getMonth());
        Map<String, Integer> destinationAirport = new HashMap<>();
        Counter counterOfAll = new Counter(surveys);
        return counterOfAll;
    }
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/surveys/fullreports")
    public Deque<FullCounter> getSurveyByDateAndYearFull(@RequestBody SurveysDTO date) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        Map<String, Map<String, Map<String, Integer>>> report = new HashMap<>();

        Map<String, Map<String, Integer>> question = new HashMap<>();

        Map<String, Integer> variableOfAnswer = new HashMap<>();

        String[] methodNames = {"findByYearAndMonthAndQ1", "findByYearAndMonthAndQ2", "findByYearAndMonthAndQ3", "findByYearAndMonthAndQ4"};

        Deque<FullCounter> fullReport = new ArrayDeque<>();

        FullCounter Q1 = new FullCounter();
        Q1.setOutstanding(new Counter(surveysRepository.findByYearAndMonthAndQ1(date.getYear(),date.getMonth(), 7)));
        Q1.setVeryGood(new Counter(surveysRepository.findByYearAndMonthAndQ1(date.getYear(),date.getMonth(), 6)));
        Q1.setGood(new Counter(surveysRepository.findByYearAndMonthAndQ1(date.getYear(),date.getMonth(), 5)));
        Q1.setAdequate(new Counter(surveysRepository.findByYearAndMonthAndQ1(date.getYear(),date.getMonth(), 4)));
        Q1.setNeedsImprovements(new Counter(surveysRepository.findByYearAndMonthAndQ1(date.getYear(),date.getMonth(), 3)));
        Q1.setPoor(new Counter(surveysRepository.findByYearAndMonthAndQ1(date.getYear(),date.getMonth(), 2)));
        Q1.setDontNot(new Counter(surveysRepository.findByYearAndMonthAndQ1(date.getYear(),date.getMonth(), 1)));
        fullReport.add(Q1);

        FullCounter Q2 = new FullCounter();
        Q2.setOutstanding(new Counter(surveysRepository.findByYearAndMonthAndQ2(date.getYear(),date.getMonth(), 7)));
        Q2.setVeryGood(new Counter(surveysRepository.findByYearAndMonthAndQ2(date.getYear(),date.getMonth(), 6)));
        Q2.setGood(new Counter(surveysRepository.findByYearAndMonthAndQ2(date.getYear(),date.getMonth(), 5)));
        Q2.setAdequate(new Counter(surveysRepository.findByYearAndMonthAndQ2(date.getYear(),date.getMonth(), 4)));
        Q2.setNeedsImprovements(new Counter(surveysRepository.findByYearAndMonthAndQ2(date.getYear(),date.getMonth(), 3)));
        Q2.setPoor(new Counter(surveysRepository.findByYearAndMonthAndQ2(date.getYear(),date.getMonth(), 2)));
        Q2.setDontNot(new Counter(surveysRepository.findByYearAndMonthAndQ2(date.getYear(),date.getMonth(), 1)));
        fullReport.add(Q2);

        FullCounter Q3 = new FullCounter();
        Q3.setOutstanding(new Counter(surveysRepository.findByYearAndMonthAndQ3(date.getYear(),date.getMonth(), 7)));
        Q3.setVeryGood(new Counter(surveysRepository.findByYearAndMonthAndQ3(date.getYear(),date.getMonth(), 6)));
        Q3.setGood(new Counter(surveysRepository.findByYearAndMonthAndQ3(date.getYear(),date.getMonth(), 5)));
        Q3.setAdequate(new Counter(surveysRepository.findByYearAndMonthAndQ3(date.getYear(),date.getMonth(), 4)));
        Q3.setNeedsImprovements(new Counter(surveysRepository.findByYearAndMonthAndQ3(date.getYear(),date.getMonth(), 3)));
        Q3.setPoor(new Counter(surveysRepository.findByYearAndMonthAndQ3(date.getYear(),date.getMonth(), 2)));
        Q3.setDontNot(new Counter(surveysRepository.findByYearAndMonthAndQ3(date.getYear(),date.getMonth(), 1)));
        fullReport.add(Q3);

        FullCounter Q4 = new FullCounter();
        Q4.setOutstanding(new Counter(surveysRepository.findByYearAndMonthAndQ4(date.getYear(),date.getMonth(), 7)));
        Q4.setVeryGood(new Counter(surveysRepository.findByYearAndMonthAndQ4(date.getYear(),date.getMonth(), 6)));
        Q4.setGood(new Counter(surveysRepository.findByYearAndMonthAndQ4(date.getYear(),date.getMonth(), 5)));
        Q4.setAdequate(new Counter(surveysRepository.findByYearAndMonthAndQ4(date.getYear(),date.getMonth(), 4)));
        Q4.setNeedsImprovements(new Counter(surveysRepository.findByYearAndMonthAndQ4(date.getYear(),date.getMonth(), 3)));
        Q4.setPoor(new Counter(surveysRepository.findByYearAndMonthAndQ4(date.getYear(),date.getMonth(), 2)));
        Q4.setDontNot(new Counter(surveysRepository.findByYearAndMonthAndQ4(date.getYear(),date.getMonth(), 1)));
        fullReport.add(Q4);

        return fullReport;
    }



    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/surveys")
    public Surveys postSu4veys(@RequestBody Iterable<SurveysDTO> surveysDTO) {
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
                if (surveyDTO.getGender().equals("M")){
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
        return null;
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

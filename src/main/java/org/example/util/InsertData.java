package org.example.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.entity.*;
import org.example.entity.Currency;
import org.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class InsertData {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private AnswerHistoryRepository answerHistoryRepository;
    @Autowired
    private CurrencyRepository currencyRepository;


    @Value("${CANT_USUARIOS}")
    private Integer CANT_USUARIOS;


    private static final String SEXO_FEMENINO = "F";
    private static final String SEXO_MASCULINO = "M";

    public void populateData() {

        List<String> countryList = listCountry();
        List<Role> roleList = roleList();

        List<String> nameList = listName();
        List<String> lastNameList = listLastName();

        answerList();
        currencyList();

        Random rand = new Random();

        for (int a = 1; a < CANT_USUARIOS; a++) {
            User user = new User();

            user.setName(RandomStringUtils.random(15, true,false));
            int randomName = rand.nextInt(nameList.size());
            user.setName(nameList.get(randomName));
            user.setLastName(lastNameList.get(rand.nextInt(lastNameList.size())));
            user.setSex((randomName % 2 == 0) ? SEXO_FEMENINO : SEXO_MASCULINO);
            user.setPhone(RandomStringUtils.random(10, false, true));
            user.setUsername(RandomStringUtils.random(a, true, true).toLowerCase());
            user.setCountry(countryList.get(rand.nextInt(countryList.size())));
            user.setRole(roleList.get(rand.nextInt(roleList.size())));
            user.setCreateDate(LocalDate.now());

            userRepository.save(user);
        }


        questionList();

        answerHistory();

    }

    private List<String> listName() {
        List<String> list = new ArrayList<>();

        list.add("Isabella");
        list.add("Benjamin");
        list.add("Francesca");
        list.add("Mateo");
        list.add("Delfina");
        list.add("Lorenzo");
        list.add("Emilia");
        list.add("Joaquin");
        list.add("Valentina");
        list.add("Valentino");
        list.add("Catalina");
        list.add("Santino");
        list.add("Martina");
        list.add("Juan Ignacio");

        return list;
    }
    private List<String> listLastName() {
        List<String> list = new ArrayList<>();

        list.add("Gomez");
        list.add("Perez");
        list.add("Gonzalez");
        list.add("Rodriguez");
        list.add("Lopez");
        list.add("Sanchez");
        list.add("Romero");
        list.add("Fernandez");
        list.add("Martinez");
        list.add("Diaz");

        return list;
    }
    private List<String> listCountry() {
        List<String> list = new ArrayList<>();

        list.add("Argentina");
        list.add("Paraguay");
        list.add("Bolivia");
        list.add("Uruguay");
        list.add("Brasil");
        list.add("Chile");

        return list;
    }
    private List<Role> roleList() {
        List<Role> roleList = new ArrayList<>();

        roleList.add(new Role(UUID.randomUUID(), "Admin"));
        roleList.add(new Role(UUID.randomUUID(), "User"));

        return roleRepository.saveAll(roleList);
    }
    private void questionList() {
        List<User> userList = userRepository.findAllByRoleName("Admin");
        List<Answer> answers = answerRepository.findAll();
        Random rand = new Random();

        List<Question> questions = new ArrayList<>();

        Question question1 = new Question();

        question1.setDetail("¿Cómo me siento?");
        question1.setCreateDateTime(new Date());
        question1.setCreatedBy(userList.get(rand.nextInt(userList.size())));
        //question1.setAnswer(answers.get(rand.nextInt(answers.size())));
        questions.add(question1);

        Question question2 = new Question();
        question2.setDetail("¿Cómo estoy?");
        question2.setCreateDateTime(new Date());
        question2.setCreatedBy(userList.get(rand.nextInt(userList.size())));
        questions.add(question2);



        //answerList.get(rand.nextInt(answerList.size())))




        questionRepository.saveAll(questions);
    }
    private List<Answer> answerList() {
        List<Answer> answerList = answerRepository.findAll();

        answerList.add(new Answer(UUID.randomUUID(), "Muy Bien"));
        answerList.add(new Answer(UUID.randomUUID(), "Bien"));
        answerList.add(new Answer(UUID.randomUUID(), "No se"));
        answerList.add(new Answer(UUID.randomUUID(), "Mal"));
        answerList.add(new Answer(UUID.randomUUID(), "Muy Mal"));

        return answerRepository.saveAll(answerList);
    }

    private List<Currency> currencyList() {
        List<Currency> currencyList = currencyRepository.findAll();

        currencyList.add(new Currency(UUID.randomUUID(), "USD"));
        currencyList.add(new Currency(UUID.randomUUID(), "Pesos"));
        currencyList.add(new Currency(UUID.randomUUID(), "Euros"));

        return currencyRepository.saveAll(currencyList);
    }

    private void answerHistory() {
        List<Question> questionList = questionRepository.findAll();
        List<User> userList = userRepository.findAll();


        for (int a = 0; a < CANT_USUARIOS; a++) {
            Random rand = new Random();
            AnswersHistory answersHistory = new AnswersHistory();

            answersHistory.setId(UUID.randomUUID());
            answersHistory.setUser(userList.get(rand.nextInt(userList.size())));
            answersHistory.setCreateDate(new Date());
            answersHistory.setQuestion(questionList.get(rand.nextInt(questionList.size())));

            answerHistoryRepository.save(answersHistory);
        }


        List<User> userListAdmin = userRepository.findAllByRoleName("Admin");
        Question question = new Question();
        question.setDetail("¿Cómo estoy ahora en este momento?");
        question.setCreateDateTime(new Date());
        question.setCreatedBy(userList.get(userListAdmin.size()));

        questionRepository.save(question);

    }
}

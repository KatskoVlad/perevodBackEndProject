package com.bank.perevod.service.validator;

import com.bank.perevod.domain.to.User;
import com.bank.perevod.exception.ServiceException;

import java.util.regex.Pattern;

/*
 * Validator for User entity.
 * Cheks the correctness of User object fields using regular expressions.
 * Regular expression for login "[а-яА-ЯёЁa-zA-Z]{2,25}" .
 * Regular expression for password "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$".
 */
public class LoginValidator implements ValidatorInterface<User> {

    private static final ValidatorInterface<User> instance = new LoginValidator();

    public LoginValidator() {
    }

    public static ValidatorInterface<User> getInstance() {
        return instance;
    }

    //    private static final String REGULAR_EXP_LOGIN = "[а-яА-Яa-zA-Z]{2,2}";
    private static final String REGULAR_EXP_LOGIN = "[a-zA-Z]";
    private static final String REGULAR_EXP_PASSWORD = "[a-zA-Z0-9]";
//    private static final String REGULAR_EXP_PASSWORD = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
    private static final Pattern patternLogin = Pattern.compile(REGULAR_EXP_LOGIN);
    private static final Pattern patternPassword = Pattern.compile(REGULAR_EXP_PASSWORD);

    /*
     * Validates fields of parameter object for correct values.
     *
     * @param user User object which is need to be validated for correctness fields.
     * @return true if validation fields of object was successfully: login contains letters of the Russian and English
     * and no longer than 25 characters,
     * password contains uppercase and lowercase letters of the English language and figures;
     * else false
     */
    @Override
    public boolean isValid(User user) throws ServiceException {
        if(user.getLogin().isEmpty()){
            throw new ServiceException("Введите логин!");
        }
        if(user.getPassword().isEmpty()){
            throw new ServiceException("Введите пароль!");
        }
        if(user.getName().isEmpty()){
            throw new ServiceException("Введите имя!");
        }
        if(user.getSurname().isEmpty()){
            throw new ServiceException("Введите фамилию!");
        }
        if(user.getIdRole()==0){
            throw new ServiceException("Выберите роль!");
        }
        if(user.getSex().isEmpty()){
            throw new ServiceException("Выберите пол!");
        }
        if(user.getEmail().isEmpty()){
            throw new ServiceException("Введите e-mail!");
        }
        return true;
    }

    @Override
    public void isValidPassword(String password1, String password2) throws ServiceException {
        if(password1.isEmpty()){
            throw new ServiceException("Введите пароль!");
        }
        if(password2.isEmpty()) {
            throw new ServiceException("Повторите пароль!");
        }
        if(!password1.equals(password2)){
            throw new ServiceException("Пароли не совпадают!");
        }
        if (password1.length()<8){
            throw new ServiceException("Пароль должен быть не менне 8 символов!");
        }
//        Matcher matcherPassword = patternPassword.matcher(password1);
//        if(!matcherPassword.matches()){
//            throw new ValidationException("Пароль не соответствует требованиям!");
//        }
    }
}

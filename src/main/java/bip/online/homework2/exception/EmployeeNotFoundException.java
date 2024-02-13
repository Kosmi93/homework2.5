package bip.online.homework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super("Сотрудник не найден.");
    }
}

package pl.skrzypczak.springbootapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping("/greeting")
    public String greeting() {
        return "hello";
    }

    @RequestMapping("/apierror")
    public ApiError apiError() {
//        HttpStatus httpStatus = new HttpStatus(HttpStatus.OK);
        ApiError apiError = new ApiError(HttpStatus.OK, "Michal Test", new EmptyStackException());

        List<ApiValidationError> errorList = new ArrayList<>();
        for(int i = 0; i<10;i++){
        ApiValidationError apiValidationError = new ApiValidationError("test "+i, "message "+i);
        errorList.add(apiValidationError);
        }
        apiError.setSubErrors(errorList);

        return apiError;
    }
}

package com.example.service.impl;

import com.example.service.ComputerService;
import org.springframework.stereotype.Service;

@Service
public class ComputerServiceImpl implements ComputerService {


    @Override
    public int calculation(int first, int second, String calculator) {
        int result = 0;
        switch (calculator) {
            case "addition(+)":
                result = first + second;
                break;
            case "subtraction(-)":
                result = first - second;
                break;
            case "multiplication(*)":
                result = first * second;
                break;
            case "division(/)":
                result = first / second;
                break;
        }
        return result;
    }
}
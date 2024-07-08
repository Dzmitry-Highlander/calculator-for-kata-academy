package service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EErrors {
    InputError ("Неверный ввод данных! Ознакомьтесь с инструкцией!");

    final String message;
}

#language: ru

Функция: Вход в личный кабинет

  @success
  Сценарий: пользователь входит в личный кабинет
    Дано открыта страница авторизации
    Когда пользователь вводит логин "test@example.com"
    И пользователь вводит пароль "qwerty123"
    И пользователь нажимает "Войти"

  @fail
  Сценарий: пользователь неудачно входит в личный кабинет
    Дано открыта страница авторизации
    Когда пользователь вводит логин "wrong@example.com"
    И пользователь вводит пароль "wrong"
    И пользователь нажимает "Войти"

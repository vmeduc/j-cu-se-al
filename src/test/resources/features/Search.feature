#language: ru

Функция: Зпрос в Яндекс

  @success
  Сценарий: пользователь ищет в Яндекс
    Дано открыта главная страница Яндекс
    Когда пользователь вводит запрос "что такое cucumber?"
    И пользователь нажимает Найти

  @fail
  Сценарий: пользователь ищет в Яндекс
    Дано открыта главная страница Яндекс
    Когда пользователь вводит запрос "что такое cucumber?"
    И пользователь плохо нажимает Найти

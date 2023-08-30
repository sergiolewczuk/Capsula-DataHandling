# Capsula-DataHandling



Lista de usuarios con un determinado rol
http://localhost:8080/user/search/findAllByRolesName?roleName=User

Cantidad de veces que fue preguntada una pregunta
http://localhost:8080/answerHistory/search/countByQuestionDetail?detail=¿Cómo me siento?






Lista de usuarios que realizaron preguntas en un rango de fechas
http://localhost:8080/user/search/findAllByAnswersCreateDateTimeBetween?startDate=2023-08-29&endDate=2023-08-31
http://localhost:8080/user/search/findAllByAnswersCreateDateGreaterThanEqualAndAnswersCreateDateLessThanEqual?startDate=2023-08-27&endDate=2023-08-28



Lista de preguntas registradas que nunca fueron preguntadas
http://localhost:8080/question/search/findByAnswersEquals

Para pegarlo directamente desde postman.
  * Configurar variables MySQL en el application.properties
  * En MainApplication - línea 22 - llama a una función para popular la BD, correrlo la primera vez y comentarla
  * Utilizar postman para conocer la respuesta de los repositorios 

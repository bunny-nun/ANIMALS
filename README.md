# Информация о проекте
Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.

## Задание
1. Используя команду cat в терминале операционной системы Linux, создать два: файла 
Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными 
(заполнив файл лошадьми, верблюдами и ослами), а затем объединить их. Просмотреть 
содержимое созданного файла.
Переименовать файл, дав ему новое имя (друзья человека).

![screenshot_1](https://github.com/bunny-nun/ANIMALS/blob/branch_1/resources/spec_fin_project_1.jpg?raw=true)

2. Создать директорию, переместить файл туда.

![screenshot_2](\resources\spec_fin_project_2.jpg)

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого
репозитория.

![screenshot_3](\resources\spec_fin_project_3.jpg)
![screenshot_4](\resources\spec_fin_project_4.jpg)
![screenshot_5](\resources\spec_fin_project_5.jpg)
![screenshot_6](\resources\spec_fin_project_6.jpg)

4. Установить и удалить deb-пакет с помощью dpkg.

![screenshot_7](\resources\spec_fin_project_7.jpg)
![screenshot_8](\resources\spec_fin_project_8.jpg)

8. Выложить историю команд в терминале ubuntu.

![screenshot_9](\resources\spec_fin_project_9.jpg)

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные 
и вьючные животные, в составы которых в случае домашних животных войдут классы:
собаки, кошки, хомяки, а в класс вьючные животные войдут: лошади, верблюды и ослы.

![diagram](\resources\spec_fin_project_11.jpg)

7. В подключенном MySQL репозитории создать базу данных “Друзья человека”.

![screenshot_10](\resources\spec_fin_project_10.jpg)

8. Создать таблицы с иерархией из диаграммы в БД.

> USE human_friends;  
> 
> DROP TABLE IF EXISTS animal;  
CREATE TABLE animal  
(  
id INT AUTO_INCREMENT PRIMARY KEY,  
animal_type VARCHAR(30)  
); 
>
> INSERT INTO animal (animal_type)  
VALUES  
('home_animal'),  
('pack_animal');
>
> DROP TABLE IF EXISTS home_animal;  
CREATE TABLE home_animal  
(  
id INT AUTO_INCREMENT PRIMARY KEY,  
type_id INT,  
animal_class VARCHAR (20),  
FOREIGN KEY (type_id) REFERENCES animal (id) ON DELETE CASCADE ON UPDATE CASCADE  
);
> 
> INSERT INTO home_animal (type_id, animal_class)  
VALUES  
(1, 'cat'),  
(1, 'dog'),  
(1, 'hamster');  
> 
> DROP TABLE IF EXISTS pack_animal;  
CREATE TABLE pack_animal  
(  
id INT AUTO_INCREMENT PRIMARY KEY,  
type_id INT,  
animal_class VARCHAR (20),  
FOREIGN KEY (type_id) REFERENCES animal (id) ON DELETE CASCADE ON UPDATE CASCADE  
);  
> 
> INSERT INTO pack_animal (type_id, animal_class)  
VALUES  
(2, 'horse'),  
(2, 'camel'),  
(2, 'donkey'); 
> 
> DROP TABLE IF EXISTS command;  
CREATE TABLE command  
(  
id INT AUTO_INCREMENT PRIMARY KEY,  
command VARCHAR(30)  
);  
> 
> INSERT INTO command (command)  
VALUES  
('sleep'),  
('eat'),    
('play'),  
('walk'),  
('sprint'),  
('allure'),  
('gallop'),  
('carry');  

![mysql_screenshot_1](\resources\mysql_1.jpg)
![mysql_screenshot_2](\resources\mysql_2.jpg)
![mysql_screenshot_3](\resources\mysql_3.jpg)
![mysql_screenshot_4](\resources\mysql_4.jpg)

>DROP TABLE IF EXISTS cat;  
CREATE TABLE cat  
(  
id INT AUTO_INCREMENT PRIMARY KEY,  
class_id INT,  
animal_name VARCHAR (20),  
birthday DATE,  
command_1 INT,  
command_2 INT,  
command_3 INT,  
FOREIGN KEY (class_id) REFERENCES home_animal (id)   
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_1) REFERENCES command (id)   
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_2) REFERENCES command (id)   
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_3) REFERENCES command (id)  
ON DELETE CASCADE ON UPDATE CASCADE  
);  
>
>DROP TABLE IF EXISTS dog;  
CREATE TABLE dog  
(  
id INT AUTO_INCREMENT PRIMARY KEY,  
class_id INT,  
animal_name VARCHAR (20),  
birthday DATE,  
command_1 INT,  
command_2 INT,  
command_3 INT,  
FOREIGN KEY (class_id) REFERENCES home_animal (id)  
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_1) REFERENCES command (id)  
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_2) REFERENCES command (id)  
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_3) REFERENCES command (id)  
ON DELETE CASCADE ON UPDATE CASCADE  
);
>
>DROP TABLE IF EXISTS hamster;  
CREATE TABLE hamster  
(  
id INT AUTO_INCREMENT PRIMARY KEY,  
class_id INT,  
animal_name VARCHAR (20),  
birthday DATE,  
command_1 INT,  
command_2 INT,  
command_3 INT,  
FOREIGN KEY (class_id) REFERENCES home_animal (id)  
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_1) REFERENCES command (id)  
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_2) REFERENCES command (id)  
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_3) REFERENCES command (id)  
ON DELETE CASCADE ON UPDATE CASCADE  
);  
>
>DROP TABLE IF EXISTS horse;  
CREATE TABLE horse  
(  
id INT AUTO_INCREMENT PRIMARY KEY,  
class_id INT,  
animal_name VARCHAR (20),  
birthday DATE,  
command_1 INT,  
command_2 INT,  
command_3 INT,  
FOREIGN KEY (class_id) REFERENCES pack_animal (id)  
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_1) REFERENCES command (id)  
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_2) REFERENCES command (id) 
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_3) REFERENCES command (id)  
ON DELETE CASCADE ON UPDATE CASCADE  
);  
>
>DROP TABLE IF EXISTS camel;  
CREATE TABLE camel  
(  
id INT AUTO_INCREMENT PRIMARY KEY,  
class_id INT,  
animal_name VARCHAR (20),  
birthday DATE,  
command_1 INT,  
command_2 INT,  
command_3 INT,  
FOREIGN KEY (class_id) REFERENCES pack_animal (id)  
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_1) REFERENCES command (id)  
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_2) REFERENCES command (id)  
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_3) REFERENCES command (id)  
ON DELETE CASCADE ON UPDATE CASCADE  
);  
>
>DROP TABLE IF EXISTS donkey;  
CREATE TABLE donkey  
(  
id INT AUTO_INCREMENT PRIMARY KEY,  
class_id INT,  
animal_name VARCHAR (20),  
birthday DATE,  
command_1 INT,  
command_2 INT,  
command_3 INT,  
FOREIGN KEY (class_id) REFERENCES pack_animal (id)  
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_1) REFERENCES command (id)  
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_2) REFERENCES command (id)  
ON DELETE CASCADE ON UPDATE CASCADE,  
FOREIGN KEY (command_3) REFERENCES command (id)  
ON DELETE CASCADE ON UPDATE CASCADE  
);

![mysql_screenshot_5](\resources\mysql_5.jpg)
![mysql_screenshot_6](\resources\mysql_6.jpg)

9. Заполнить низкоуровневые таблицы именами (животных), командами которые они
выполняют и датами рождения.

>INSERT INTO cat (class_id, animal_name, birthday, command_1, command_2, command_3)  
VALUES  
(1, 'Betty', '2015-12-31', 1, 2, 3),  
(1, 'Whiskers', '2020-04-22', 1, 2, 4),    
(1, 'Garfield', '2022-07-24', 1, 2, 5);  
>
>INSERT INTO dog (class_id, animal_name, birthday, command_1, command_2, command_3)  
VALUES  
(2, 'Rufus', '2012-06-25', 2, 3, 5),  
(2, 'Kim', '2021-11-16', 2, 5, 8),    
(2, 'Indy', '2021-05-09', 1, 2, 3);  
>
>INSERT INTO hamster (class_id, animal_name, birthday, command_1, command_2, command_3)  
VALUES  
(3, 'Mr. Gibbles', '2022-03-01', 1, 2, 5),  
(3, 'Tony', '2023-06-10', 1, 2, 5),    
(3, 'Sunshine', '2021-09-02', 1, 2, 5);  
>
>INSERT INTO horse (class_id, animal_name, birthday, command_1, command_2, command_3)  
VALUES  
(1, 'Whinney', '2013-08-17', 1, 2, 6),  
(1, 'Pooh', '2021-04-22', 1, 2, 7),    
(1, 'Jesus', '2020-06-11', 2, 6, 7);  
>
>INSERT INTO camel (class_id, animal_name, birthday, command_1, command_2, command_3)  
VALUES  
(2, 'Todd', '2017-02-27', 1, 4, 8),  
(2, 'Akasha', '2014-10-07', 2, 4, 8),    
(2, 'Jose', '2022-04-30', 1, 4, 8);  
>
>INSERT INTO donkey (class_id, animal_name, birthday, command_1, command_2, command_3)  
VALUES  
(3, 'Leroy', '2019-12-01', 1, 2, 8),  
(3, 'Quinton', '2015-10-10', 1, 2, 8),    
(3, 'Aurelius', '2023-04-02', 1, 2, 8);  

![mysql_screenshot_7](\resources\mysql_7.jpg)
![mysql_screenshot_8](\resources\mysql_8.jpg)
![mysql_screenshot_9](\resources\mysql_9.jpg)
![mysql_screenshot_10](\resources\mysql_10.jpg)
![mysql_screenshot_11](\resources\mysql_11.jpg)
![mysql_screenshot_12](\resources\mysql_12.jpg)

10. Удалить из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник
на зимовку. Объединить таблицы лошади и ослы в одну таблицу.

>DELETE FROM pack_animal WHERE animal_class = 'camel';

![mysql_screenshot_13](\resources\mysql_13.jpg)

>SELECT class_id, animal_name, birthday, command_1, command_2, command_3 FROM horse  
UNION  
SELECT  class_id, animal_name, birthday, command_1, command_2, command_3 FROM donkey;

![mysql_screenshot_14](\resources\mysql_14.jpg)

11. Создать новую таблицу “молодые животные” в которую попадут все животные старше
1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать
возраст животных в новой таблице.

>DROP TABLE IF EXISTS young_animal;  
CREATE TABLE young_animal AS  
SELECT animal_name, CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' year(s) ',  
MOD(TIMESTAMPDIFF(MONTH, birthday, CURDATE()), 12), ' month(s)') AS age  
FROM cat WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) >= 1 AND 
TIMESTAMPDIFF(YEAR, birthday, CURDATE()) < 3  
UNION  
SELECT animal_name, CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' year(s) ',  
MOD(TIMESTAMPDIFF(MONTH, birthday, CURDATE()), 12), ' month(s)') AS age  
FROM dog WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) >= 1 AND  
TIMESTAMPDIFF(YEAR, birthday, CURDATE()) < 3  
UNION  
SELECT animal_name, CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' year(s) ',  
MOD(TIMESTAMPDIFF(MONTH, birthday, CURDATE()), 12), ' month(s)') AS age  
FROM hamster WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) >= 1 AND  
TIMESTAMPDIFF(YEAR, birthday, CURDATE()) < 3  
UNION  
SELECT animal_name, CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' year(s) ',  
MOD(TIMESTAMPDIFF(MONTH, birthday, CURDATE()), 12), ' month(s)') AS age  
FROM horse WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) >= 1 AND  
TIMESTAMPDIFF(YEAR, birthday, CURDATE()) < 3  
UNION  
SELECT animal_name, CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' year(s) ',  
MOD(TIMESTAMPDIFF(MONTH, birthday, CURDATE()), 12), ' month(s)') AS age  
FROM donkey WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) >= 1 AND  
TIMESTAMPDIFF(YEAR, birthday, CURDATE()) < 3;

![mysql_screenshot_15](\resources\mysql_15.jpg)

12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую
принадлежность к старым таблицам.

>DROP TABLE IF EXISTS all_animals;  
CREATE TABLE all_animals AS  
SELECT c.animal_name, c.birthday, hh1.animal_class AS `table_name`,   
cc1.command AS command_1, cc2.command AS command_2,  
cc3.command AS command_3 FROM cat AS c  
LEFT JOIN home_animal AS hh1 ON c.class_id = hh1.id  
LEFT JOIN command AS cc1 ON c.command_1 = cc1.id  
LEFT JOIN command AS cc2 ON c.command_2 = cc2.id  
LEFT JOIN command AS cc3 ON c.command_3 = cc3.id  
UNION  
SELECT d.animal_name, d.birthday, hh1.animal_class AS `table_name`,  
cc1.command AS command_1, cc2.command AS command_2,  
cc3.command AS command_3 FROM dog AS d  
LEFT JOIN home_animal AS hh1 ON d.class_id = hh1.id  
LEFT JOIN command AS cc1 ON d.command_1 = cc1.id  
LEFT JOIN command AS cc2 ON d.command_2 = cc2.id  
LEFT JOIN command AS cc3 ON d.command_3 = cc3.id  
UNION    
SELECT h.animal_name, h.birthday, hh1.animal_class AS `table_name`,  
cc1.command AS command_1, cc2.command AS command_2,  
cc3.command AS command_3 FROM hamster AS h  
LEFT JOIN home_animal AS hh1 ON h.class_id = hh1.id  
LEFT JOIN command AS cc1 ON h.command_1 = cc1.id  
LEFT JOIN command AS cc2 ON h.command_2 = cc2.id  
LEFT JOIN command AS cc3 ON h.command_3 = cc3.id  
UNION  
SELECT h.animal_name, h.birthday, pp1.animal_class AS `table_name`,  
cc1.command AS command_1, cc2.command AS command_2,  
cc3.command AS command_3 FROM horse AS h  
LEFT JOIN pack_animal AS pp1 ON h.class_id = pp1.id  
LEFT JOIN command AS cc1 ON h.command_1 = cc1.id  
LEFT JOIN command AS cc2 ON h.command_2 = cc2.id  
LEFT JOIN command AS cc3 ON h.command_3 = cc3.id  
UNION  
SELECT d.animal_name, d.birthday, pp1.animal_class AS `table_name`,  
cc1.command AS command_1, cc2.command AS command_2,  
cc3.command AS command_3 FROM donkey AS d  
LEFT JOIN pack_animal AS pp1 ON d.class_id = pp1.id  
LEFT JOIN command AS cc1 ON d.command_1 = cc1.id  
LEFT JOIN command AS cc2 ON d.command_2 = cc2.id  
LEFT JOIN command AS cc3 ON d.command_3 = cc3.id;  

![mysql_screenshot_16](\resources\mysql_16.jpg)
![mysql_screenshot_17](\resources\mysql_17.jpg)

13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
14. Написать программу, имитирующую работу реестра домашних животных.
В программе должен быть реализован следующий функционал:
    1. Завести новое животное;
    2. Определять животное в правильный класс;
    3. Увидеть список команд, которое выполняет животное;
    4. Обучить животное новым командам;
    5. Реализовать навигацию по меню;

    ![program_screenshot_1](\resources\spec_fin_project_12.jpg)
    
    7. Создать класс Счетчик, у которого есть метод add(), увеличивающий значение
    внутренней int переменной на 1 при нажатии “Завести новое животное”.
    Сделайте так, чтобы с объектом такого типа можно было работать в блоке 
    try-with-resources. Нужно бросить исключение, если работа с объектом 
    типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение 
    считать в ресурсе try, если при заведении животного заполнены все поля.


![program_screenshot_2](\resources\spec_fin_project_13.jpg)

![program_screenshot_3](\resources\spec_fin_project_14.jpg)
...
![program_screenshot_4](\resources\spec_fin_project_15.jpg)

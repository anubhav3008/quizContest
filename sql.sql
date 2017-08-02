CREATE TABLE question (
    id int NOT NULL AUTO_INCREMENT,
    question varchar(255) NOT NULL,
    option1  varchar(255),
    option2 varchar(255),
    option3 varchar(255),
    option4 varchar(255),
    answer varchar(255),
    questionlevel int not null,
    PRIMARY KEY (ID)
);

insert into question(question,option1,option2,option3,option4,answer,questionlevel)
values("What is the capital of India","Delhi","Mumbai","Kolkata","Chennai","Delhi",1);

insert into question(question,option1,option2,option3,option4,answer,questionlevel)
values("Who is president of India","Ram Nath Kovind","Pranab Mukharjee","Pratibha Patil","vainkaiya Naidu","Ram Nath Kovind",2);


insert into question(question,option1,option2,option3,option4,answer,questionlevel)
values("With Which of these states do Chhattisgarh, Jharkhand and Andhra Pradesh all share their borders ?
","Madhya Pradesh","Bihar","Orissa","Uttar Pradesh","Orissa",3);


insert into question(question,option1,option2,option3,option4,answer,questionlevel)
values("Which of these is not a recommended mineral in the human diet ?","Strontium","Potassium","Iron","calcium","Potassium",4);


insert into question(question,option1,option2,option3,option4,answer,questionlevel)
values("Eating which of these dishes would qualify one as a non-vegetarian?
","Malai Kofta","Navratan Korma","Gatte ki sabzi","Tandoori Naan","Navratan Korma",5);

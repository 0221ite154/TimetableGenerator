# 🗓️ Timetable Generator Web App

A simple and efficient Timetable Generator built using Spring Boot (Backend) and HTML/CSS/JavaScript (Frontend).
This project helps colleges and institutions automatically generate, manage, and view faculty/class timetables.


# 🚀 Features

Generate Timetable → Creates an 8x6 timetable JSON for classes with faculty and lab details.

View Faculty Timetable → View an individual faculty’s timetable in JSON format.

Add Faculty → Easily add faculty details to the database.

Classroom Support → Assign timetables based on className.

User-Friendly UI → Simple frontend interface to interact with APIs.


# 🛠️ Tech Stack

Frontend:

HTML, CSS, JavaScript

Backend:

Java Spring Boot

REST APIs

Database:

MySQL (or any preferred relational DB)

# 📦 Installation & Setup
Backend (Spring Boot)

// Clone the repository

git clone https://github.com/your-username/timetable-generator.git

cd timetable-generator

// Run the Spring Boot app

mvn spring-boot:run

# Frontend

Simply open the Frontend.html file in your browser or deploy it on any static server.

# 📊 API Endpoints

POST /generateTimetable → Generates timetable

GET /faculty/{facultyId} → Get faculty timetable

POST /addFaculty → Add new faculty


# Sample Request (Generate Timetable):

{
  "className": "ITB4",
  "faculties": [
    {
      "facultyId": 1234,
      "subjectName": "DBMS",
      "totalLecturePerWeek": 4
    }
  ],
  "labs": [
    {
      "labId": 1235,
      "subjectName": "DBMS",
      "totalLecturePerWeek": 4
    }
  ]
}

# 🎨 Screenshots

1)Admin login Page
<img width="2880" height="1800" alt="image" src="https://github.com/user-attachments/assets/c09fb4c7-e4a2-48a9-bccc-1ce8f7ba4254" />

2)Generate Timetable
<img width="2880" height="1800" alt="image" src="https://github.com/user-attachments/assets/4fe272d9-d153-4456-a98e-ecade98bbd7c" />

3)Manual Faculty Entry
<img width="2880" height="1800" alt="image" src="https://github.com/user-attachments/assets/c3be2375-f0bc-4b2d-ab15-bdd9e6b61397" />

4) View Faculty Timetable
   <img width="2880" height="1800" alt="image" src="https://github.com/user-attachments/assets/144635b2-e2b3-43ea-bde7-0322bf0dcbe5" />
   
5)Faculty login Page
<img width="1440" height="900" alt="Screenshot 2025-09-08 at 2 08 03 AM" src="https://github.com/user-attachments/assets/38e8d373-b513-4aae-b7bc-cb97670e4613" />

6)Faculty Dashboard
<img width="1440" height="900" alt="Screenshot 2025-09-08 at 2 11 17 AM" src="https://github.com/user-attachments/assets/8a828623-19fc-41a5-8976-f0b0912e29f3" />









#Endpoints
#Create Student
Endpoint: POST /students
Description: Create a new student.
Request Body: JSON representing the student's information (e.g., name, roll number, marks).
Response: The created student with a unique ID.


#Get Student by ID
Endpoint: GET /students/{studentId}
Description: Retrieve a student by their unique ID.
Response: JSON representation of the student with the specified ID.

#Update Student by ID
Endpoint: PUT /students/{studentId}
Description: Update the details of a student by their unique ID.
Request Body: JSON representing the updated student information.
Response: The updated student information.

#Delete Student by ID
Endpoint: DELETE /students/{studentId}
Description: Delete a student by their unique ID.
Response: Confirmation message of successful deletion.

#Get Students by Marks
Endpoint: GET /students/marks/{minMarks}
Description: Retrieve all students with marks greater than or equal to the specified value.
Response: A list of students matching the criteria.

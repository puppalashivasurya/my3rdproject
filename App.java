#include <stdio.h>
#include <string.h>

#define MAX_STUDENTS 10
#define NAME_LENGTH 50

typedef struct {
    char name[NAME_LENGTH];
    int score;
} Student;

// Function to add a student
int addStudent(Student students[], int count, const char* name, int score) {
    if (count >= MAX_STUDENTS) {
        printf("Cannot add more students. Limit reached.\n");
        return count;
    }
    if (score < 0 || score > 100) {
        printf("Invalid score for %s. Must be 0-100.\n", name);
        return count;
    }
    strncpy(students[count].name, name, NAME_LENGTH-1);
    students[count].name[NAME_LENGTH-1] = '\0'; // Ensure null termination
    students[count].score = score;
    return count + 1;
}

// Function to calculate average score
double calculateAverage(Student students[], int count) {
    if (count == 0) return 0.0;

    int total = 0;
    for (int i = 0; i < count; i++) {
        total += students[i].score;
    }
    return (double)total / count;
}

// Function to print all students
void printStudents(Student students[], int count) {
    printf("Student List:\n");
    for (int i = 0; i < count; i++) {
        printf("- %s: %d\n", students[i].name, students[i].score);
    }
}

int main() {
    Student students[MAX_STUDENTS];
    int count = 0;

    count = addStudent(students, count, "Alice", 85);
    count = addStudent(students, count, "Bob", 92);
    count = addStudent(students, count, "Charlie", 78);
    count = addStudent(students, count, "Dave", 105); // Invalid score, will be ignored

    printStudents(students, count);

    double average = calculateAverage(students, count);
    printf("Average score: %.2f\n", average);

    return 0;
}

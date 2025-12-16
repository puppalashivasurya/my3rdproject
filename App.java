class Student:
    def __init__(self, name, score):
        self.name = name
        self.score = score

class StudentManager:
    def __init__(self):
        self.students = []

    def add_student(self, name, score):
        if score < 0 or score > 100:
            print(f"Invalid score for {name}. Must be 0-100.")
            return
        self.students.append(Student(name, score))

    def calculate_average(self):
        if not self.students:
            return 0
        total = sum(student.score for student in self.students)
        return total / len(self.students)

    def print_students(self):
        print("Student List:")
        for student in self.students:
            print(f"- {student.name}: {student.score}")

def main():
    manager = StudentManager()
    manager.add_student("Alice", 85)
    manager.add_student("Bob", 92)
    manager.add_student("Charlie", 78)
    manager.add_student("Dave", 105)  # Invalid score, will be ignored

    manager.print_students()
    average = manager.calculate_average()
    print(f"Average score: {average:.2f}")

if __name__ == "__main__":
    main()

}

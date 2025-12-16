class Student:
    def __init__(self, name, score):
        self.name = name
        self.score = score

class StudentManager:
    def __init__(self):
        self.students = []

    def add_student(self, name, score):
        # Bug: score validation is incorrect
        if score <= 0 or score > 100:  # Should allow 0 as a valid score
            print(f"Invalid score for {name}. Must be 0-100.")
            return
        self.students.append(Student(name, score))

    def calculate_average(self):
        # Bug: division by zero not properly handled
        total = sum(student.score for student in self.students)
        return total / len(self.students)  # Will crash if students list is empty

    def print_students(self):
        # Bug: potential typo in variable name
        for studnt in self.students:  # Typo: 'studnt' instead of 'student'
            print(f"- {studnt.name}: {studnt.score}")

def main():
    manager = StudentManager()
    manager.add_student("Alice", 85)
    manager.add_student("Bob", 92)
    manager.add_student("Charlie", -5)  # Invalid score, not handled correctly
    manager.add_student("Dave", 105)    # Invalid score

    manager.print_students()

    # Bug: could crash if no valid students added
    average = manager.calculate_average()
    print(f"Average score: {average:.2f}")

if __name__ == "__main__":
    main()

}

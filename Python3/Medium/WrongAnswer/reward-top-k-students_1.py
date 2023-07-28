class Solution:
    def topStudents(self, positive_feedback: List[str], negative_feedback: List[str], report: List[str], student_id: List[int], k: int) -> List[int]:
        
        positive_feedback = set(positive_feedback)
        negative_feedback = set(negative_feedback)
        students = {}
        for i, r in enumerate(report):
            for w in r.split():
                if w in positive_feedback:
                    students[student_id[i]] = students.get(student_id[i], 0) + 3
                elif w in negative_feedback:
                    students[student_id[i]] = students.get(student_id[i], 0) - 1
        return [i for i, _ in sorted(students.items(), key=lambda x: (-x[1], x[0]))][:k]
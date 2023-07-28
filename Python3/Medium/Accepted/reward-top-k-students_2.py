class Solution:
    def topStudents(self, positive_feedback: List[str], negative_feedback: List[str], report: List[str], student_id: List[int], k: int) -> List[int]:
        
        positive_feedback = set(positive_feedback)
        negative_feedback = set(negative_feedback)
        student_id_to_points = {}
        for i in range(len(report)):
            student_id_to_points[student_id[i]] = student_id_to_points.get(student_id[i], 0) + sum(3 if word in positive_feedback else -1 for word in report[i].split() if word in positive_feedback or word in negative_feedback)
        return [student_id for student_id, points in sorted(student_id_to_points.items(), key=lambda x: (-x[1], x[0]))[:k]]
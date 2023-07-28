class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        
        # 1. Sort classes by the increase in pass ratio
        # 2. Assign the first extraStudents students to the classes with the highest increase in pass ratio
        # 3. Calculate the average pass ratio
        # 4. Repeat 1-3 until all extraStudents students are assigned
        # 5. Return the average pass ratio
        # Time  complexity: O(m * log(m)) where m is the number of classes
        # Space complexity: O(m)
        def get_increase_in_pass_ratio(passed, total):
            return (passed + 1) / (total + 1) - passed / total
        def get_average_pass_ratio(passed, total):
            return passed / total
        def get_average_pass_ratio_with_extra_students(passed, total, extra_students):
            return (passed + extra_students) / (total + extra_students)
        def get_average_pass_ratio_with_extra_students_assigned(classes, extra_students):
            return sum(get_average_pass_ratio_with_extra_students(passed, total, extra_students) for passed, total in classes) / len(classes)
        classes.sort(key=lambda x: get_increase_in_pass_ratio(x[0], x[1]), reverse=True)
        return get_average_pass_ratio_with_extra_students_assigned(classes, extraStudents)
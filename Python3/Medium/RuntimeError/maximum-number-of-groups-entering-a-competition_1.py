class Solution:
    def maximumGroups(self, grades: List[int]) -> int:
        
        
        # O(nlogn) time complexity, O(n) space complexity
        # 1. sort the grades
        # 2. loop through the grades, and put it into a group
        # 3. if the sum of the current group is less than the last group, then put it in the last group
        # 4. if the sum of the current group is greater than the last group, then put it in a new group
        # 5. return the number of groups
        
        grades.sort()
        groups = []
        for grade in grades:
            if not groups or sum(groups[-1]) + grade < sum(groups[-1]) * 2:
                groups[-1].append(grade)
            else:
                groups.append([grade])
        return len(groups)
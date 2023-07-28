class Solution:
    def scoreOfStudents(self, s: str, answers: List[int]) -> int:
        
        def calculate(s):
            nums = []
            op = '+'
            i = 0
            while i < len(s):
                if s[i].isdigit():
                    j = i + 1
                    while j < len(s) and s[j].isdigit():
                        j += 1
                    num = int(s[i:j])
                    if op == '+':
                        nums.append(num)
                    elif op == '*':
                        nums.append(nums.pop() * num)
                    i = j
                else:
                    op = s[i]
                    i += 1
            return sum(nums)
        
        correct = calculate(s)
        wrong = {}
        for i in range(len(s)):
            if s[i] == '+':
                wrong[calculate(s[:i]) + calculate(s[i + 1:])] = True
        return sum(5 if a == correct else 2 if a in wrong else 0 for a in answers)
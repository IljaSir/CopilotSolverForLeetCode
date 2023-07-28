class Solution:
    def maxCompatibilitySum(self, students: List[List[int]], mentors: List[List[int]]) -> int:
        
        
        def get_score(s, m):
            return sum([1 if s[i] == m[i] else 0 for i in range(len(s))])
        
        def get_max_score(students, mentors, idx, memo):
            if idx == len(students):
                return 0
            if idx in memo:
                return memo[idx]
            max_score = 0
            for i in range(len(mentors)):
                score = get_score(students[idx], mentors[i])
                max_score = max(max_score, score + get_max_score(students, mentors[:i] + mentors[i+1:], idx+1, memo))
            memo[idx] = max_score
            return max_score
        
        return get_max_score(students, mentors, 0, {})
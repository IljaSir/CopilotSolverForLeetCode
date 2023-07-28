class Solution:
    def scoreOfStudents(self, s: str, answers: List[int]) -> int:
        
        
        def dfs(s):
            if s.isdigit():
                return [int(s)]
            res = []
            for i in range(len(s)):
                if s[i] in '+*':
                    left = dfs(s[:i])
                    right = dfs(s[i+1:])
                    for l in left:
                        for r in right:
                            if s[i] == '+':
                                res.append(l+r)
                            else:
                                res.append(l*r)
            return res
        
        valid = set(dfs(s))
        res = 0
        for a in answers:
            if a in valid:
                res += 5
            elif a == eval(s):
                res += 2
        return res
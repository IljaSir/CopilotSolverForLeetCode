class Solution:
    def repeatedCharacter(self, s: str) -> str:
        
        d = {}
        for i in s:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1
        for key, value in d.items():
            if value > 1:
                return key
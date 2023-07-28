class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        
        d = {}
        for a in answers:
            if a not in d: d[a] = 1
            else: d[a] += 1
        s = 0
        for k, v in d.items():
            if v <= k+1: s += k+1
            else:
                s += (k+1) * (v//(k+1))
                if v%(k+1) != 0: s += k+1
        return s
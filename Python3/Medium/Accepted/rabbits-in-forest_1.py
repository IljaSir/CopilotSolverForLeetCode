class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        
        d = {}
        for i in answers:
            if i not in d:
                d[i] = 1
            else:
                d[i] += 1
        res = 0
        for k, v in d.items():
            res += (v + k) // (k+1) * (k+1)
        return res
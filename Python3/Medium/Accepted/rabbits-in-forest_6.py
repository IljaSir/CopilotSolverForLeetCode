class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        
        from collections import Counter
        c = Counter(answers)
        ans = 0
        for k, v in c.items():
            ans += int((v+k)/(k+1)) * (k+1)
        return ans
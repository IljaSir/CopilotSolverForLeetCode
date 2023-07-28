class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        
        if not answers:
            return 0
        if len(answers) == 1:
            return answers[0] + 1
        d = {}
        for i in answers:
            d[i] = d.get(i, 0) + 1
        ans = 0
        for i in d:
            if d[i] % (i + 1) == 0:
                ans += d[i]
            else:
                ans += (d[i] // (i + 1) + 1) * (i + 1)
        return ans
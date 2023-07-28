class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        
        ans = 0
        d = {}
        for i in answers:
            if i == 0:
                ans += 1
            else:
                if i in d:
                    d[i] += 1
                else:
                    d[i] = 1
        for i in d:
            if i + 1 > d[i]:
                ans += i + 1
            else:
                ans += (d[i] // (i + 1)) * (i + 1)
                if d[i] % (i + 1) != 0:
                    ans += i + 1
        return ans
class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        
        if not answers:
            return 0
        ans = 0
        d = collections.defaultdict(int)
        for i in answers:
            d[i] += 1
        for k, v in d.items():
            ans += (v + k) // (k + 1) * (k + 1)
        return ans
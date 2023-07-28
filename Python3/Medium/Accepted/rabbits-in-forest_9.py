class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        
        if not answers: return 0
        cnt = collections.Counter(answers)
        return sum((k + v) // (k + 1) * (k + 1) for k, v in cnt.items())
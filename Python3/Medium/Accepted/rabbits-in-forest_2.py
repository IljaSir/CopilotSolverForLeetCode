class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        
        from collections import Counter
        c = Counter(answers)
        return sum((x + y) // (y + 1) * (y + 1) for y, x in c.items())
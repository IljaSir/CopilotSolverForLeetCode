class Solution:
    def alternateDigitSum(self, n: int) -> int:
        
        n = str(n)
        n = [int(x) for x in n]
        for i in range(1, len(n)):
            n[i] = -n[i]
        return sum(n)
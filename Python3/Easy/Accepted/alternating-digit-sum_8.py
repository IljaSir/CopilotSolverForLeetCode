class Solution:
    def alternateDigitSum(self, n: int) -> int:
        
        n = str(n)
        return sum(int(n[i]) * ((-1)**i) for i in range(len(n)))
class Solution:
    def countSpecialNumbers(self, n: int) -> int:
        
        return sum(len(set(str(i))) == len(str(i)) for i in range(1, n + 1))
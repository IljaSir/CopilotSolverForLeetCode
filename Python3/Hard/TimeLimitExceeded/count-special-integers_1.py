class Solution:
    def countSpecialNumbers(self, n: int) -> int:
        
        return len([i for i in range(1, n+1) if len(set(str(i))) == len(str(i))])
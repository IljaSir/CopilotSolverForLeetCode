class Solution:
    def isThree(self, n: int) -> bool:
        
        return len([1 for i in range(1, n+1) if n%i==0])==3
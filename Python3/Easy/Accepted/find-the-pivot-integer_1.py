class Solution:
    def pivotInteger(self, n: int) -> int:
        
        for i in range(1, n+1):
            if sum(range(1,i)) == sum(range(i+1, n+1)):
                return i
        return -1
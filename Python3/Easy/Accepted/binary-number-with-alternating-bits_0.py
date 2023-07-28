class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        
        n = bin(n)[2:]
        for i in range(len(n)-1):
            if n[i] == n[i+1]:
                return False
        return True
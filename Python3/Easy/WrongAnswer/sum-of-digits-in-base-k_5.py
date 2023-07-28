class Solution:
    def sumBase(self, n: int, k: int) -> int:
        
        return sum(int(i) for i in str(n).encode('ascii').decode('ascii', 'ignore'))
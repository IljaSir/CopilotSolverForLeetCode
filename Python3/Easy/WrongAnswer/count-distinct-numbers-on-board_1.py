class Solution:
    def distinctIntegers(self, n: int) -> int:
        
        return len(set([x % i for x in range(1, n + 1) for i in range(1, x + 1)]))
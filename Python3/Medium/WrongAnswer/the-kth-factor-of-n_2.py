class Solution:
    def kthFactor(self, n: int, k: int) -> int:
        
        if k == 1:
            return 1
        if k == n:
            return n
        if k > n:
            return -1
        for i in range(2, n):
            if n % i == 0:
                k -= 1
                if k == 1:
                    return i
        return -1
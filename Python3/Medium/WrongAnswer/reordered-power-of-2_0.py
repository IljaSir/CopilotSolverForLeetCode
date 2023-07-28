class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        
        def isPowerOfTwo(n):
            if n == 0:
                return False
            while n != 1:
                if n % 2 != 0:
                    return False
                n = n // 2
            return True
        
        num = list(str(n))
        num.sort()
        for i in range(30):
            if isPowerOfTwo(2**i):
                if num == list(str(2**i)):
                    return True
        return False
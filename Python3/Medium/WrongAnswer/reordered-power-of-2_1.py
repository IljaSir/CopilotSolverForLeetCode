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
        s = str(n)
        arr = set()
        for i in range(len(s)):
            for j in range(len(s)):
                if i != j:
                    t = s[i] + s[j]
                    if len(t) == len(s):
                        if int(t) not in arr:
                            arr.add(int(t))
        for i in arr:
            if isPowerOfTwo(i):
                return True
        return False
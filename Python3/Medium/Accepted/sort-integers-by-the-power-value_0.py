class Solution:
    def getKth(self, lo: int, hi: int, k: int) -> int:
        
        
        def power(x):
            if x == 1:
                return 0
            elif x % 2 == 0:
                return 1 + power(x // 2)
            else:
                return 1 + power(3 * x + 1)
        
        arr = []
        for i in range(lo, hi + 1):
            arr.append((power(i), i))
        
        arr.sort()
        return arr[k - 1][1]
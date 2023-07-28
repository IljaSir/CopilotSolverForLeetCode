class Solution:
    def getKth(self, lo: int, hi: int, k: int) -> int:
        
        
        def f(x):
            if x == 1:
                return 0
            if x % 2 == 0:
                return 1 + f(x // 2)
            else:
                return 1 + f(3 * x + 1)
        
        return sorted(range(lo, hi + 1), key=f)[k - 1]
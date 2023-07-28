class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        
        a = [int(x) for x in str(n)]
        s = 0
        p = 1
        for i in a:
            s += i
            p *= i
        return p - s
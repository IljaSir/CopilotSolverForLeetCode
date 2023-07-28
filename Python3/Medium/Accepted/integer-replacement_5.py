class Solution:
    def integerReplacement(self, n: int) -> int:
        
        def helper(n, cnt):
            if n == 1:
                return cnt
            if n % 2 == 0:
                return helper(n // 2, cnt + 1)
            else:
                return min(helper(n + 1, cnt + 1), helper(n - 1, cnt + 1))
        return helper(n, 0)
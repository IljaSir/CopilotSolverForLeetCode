class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        
        def dfs(n, num, k):
            if n == 0:
                res.append(num)
                return
            tail = num % 10
            if tail + k < 10:
                dfs(n - 1, num * 10 + tail + k, k)
            if k != 0 and tail - k >= 0:
                dfs(n - 1, num * 10 + tail - k, k)
        res = []
        for i in range(1, 10):
            dfs(n - 1, i, k)
        return res
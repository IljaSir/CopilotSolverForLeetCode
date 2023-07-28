class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        
        if n == 1:
            return list(range(10))
        res = []
        def dfs(n, num):
            if n == 0:
                res.append(num)
                return
            last_digit = num % 10
            for i in [last_digit + k, last_digit - k]:
                if 0 <= i <= 9:
                    dfs(n - 1, num * 10 + i)
        for i in range(1, 10):
            dfs(n - 1, i)
        return res
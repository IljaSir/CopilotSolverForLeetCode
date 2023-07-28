class Solution:
    def profitableSchemes(self, n: int, minProfit: int, group: List[int], profit: List[int]) -> int:
        
        
        def dfs(i, p, g, mod):
            if p < minProfit:
                return 0
            if i == len(group):
                return 1
            if (i, p, g) in cache:
                return cache[(i, p, g)]
            res = 0
            if g + group[i] <= n:
                res += dfs(i + 1, p + profit[i], g + group[i], mod)
            res += dfs(i + 1, p, g, mod)
            cache[(i, p, g)] = res % mod
            return cache[(i, p, g)]
        
        cache = {}
        mod = 10 ** 9 + 7
        return dfs(0, 0, 0, mod)
class Solution:
    def canCross(self, stones: List[int]) -> bool:
        
        if stones[1] != 1:
            return False
        dp = {}
        for stone in stones:
            dp[stone] = set()
        dp[1].add(1)
        for stone in stones:
            for jump in dp[stone]:
                for i in range(jump-1, jump+2):
                    if i > 0 and stone+i in dp:
                        dp[stone+i].add(i)
        return len(dp[stones[-1]]) > 0
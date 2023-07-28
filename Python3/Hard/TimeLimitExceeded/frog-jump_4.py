class Solution:
    def canCross(self, stones: List[int]) -> bool:
        
        if stones[1] != 1:
            return False
        if len(stones) == 2:
            return True
        dp = [set() for _ in range(len(stones))]
        dp[0].add(0)
        dp[1].add(1)
        for i in range(2, len(stones)):
            for j in range(i-1, -1, -1):
                for k in dp[j]:
                    if stones[i] - stones[j] == k or stones[i] - stones[j] == k + 1 or stones[i] - stones[j] == k - 1:
                        dp[i].add(stones[i] - stones[j])
                        break
        return len(dp[-1]) > 0
class Solution:
    def stoneGameVIII(self, stones: List[int]) -> int:
        
        s = sum(stones)
        mx = s - stones[0]
        for i in range(1, len(stones)-1):
            s -= stones[i]
            mx = max(mx, s - mx)
        return mx
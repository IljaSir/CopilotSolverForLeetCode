class Solution:
    def minCost(self, nums: List[int], k: int) -> int:
        
        n = len(nums)
        @lru_cache(None)
        def dfs(i, c):
            if c == 0:
                return 0
            if i == n:
                return float('inf')
            ans = dfs(i+1, c)
            cnt = [0]*n
            for j in range(i, n):
                cnt[nums[j]] += 1
                if cnt[nums[j]] == 1:
                    ans = min(ans, dfs(j+1, c-1) + k + j-i+1 - cnt[nums[j]])
                elif cnt[nums[j]] == 2:
                    ans = min(ans, dfs(j+1, c-1) + k + j-i+1 - cnt[nums[j]])
            return ans
        return dfs(0, k)
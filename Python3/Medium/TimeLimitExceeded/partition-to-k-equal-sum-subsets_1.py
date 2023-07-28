class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        
        if sum(nums) % k != 0: return False
        target = sum(nums) // k
        nums.sort(reverse=True)
        if nums[0] > target: return False
        visited = [False] * len(nums)
        def dfs(k, start, cur_sum):
            if k == 1: return True
            if cur_sum == target:
                return dfs(k-1, 0, 0)
            for i in range(start, len(nums)):
                if not visited[i]:
                    visited[i] = True
                    if dfs(k, i+1, cur_sum + nums[i]):
                        return True
                    visited[i] = False
            return False
        return dfs(k, 0, 0)
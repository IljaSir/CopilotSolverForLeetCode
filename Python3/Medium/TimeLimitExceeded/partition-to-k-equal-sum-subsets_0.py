class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        
        target, rem = divmod(sum(nums), k)
        if rem or max(nums) > target:
            return False
        nums.sort(reverse=True)
        def dfs(groups):
            if not nums:
                return True
            v = nums.pop()
            for i, group in enumerate(groups):
                if group + v <= target:
                    groups[i] += v
                    if dfs(groups):
                        return True
                    groups[i] -= v
                if not group:
                    break
            nums.append(v)
            return False
        return dfs([0] * k)
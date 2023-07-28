class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        
        if k == 1:
            return True
        if k == len(nums):
            return len(set(nums)) == 1
        if len(nums) < k:
            return False
        if sum(nums) % k != 0:
            return False
        target = sum(nums) // k
        nums.sort()
        if nums[-1] > target:
            return False
        while nums and nums[-1] == target:
            nums.pop()
            k -= 1
        def dfs(nums, k, target, cursum, used):
            if k == 1:
                return True
            if cursum == target:
                return dfs(nums, k - 1, target, 0, used)
            for i in range(len(nums)):
                if used[i]:
                    continue
                if cursum + nums[i] > target:
                    break
                used[i] = True
                if dfs(nums, k, target, cursum + nums[i], used):
                    return True
                used[i] = False
            return False
        return dfs(nums, k, target, 0, [False] * len(nums))
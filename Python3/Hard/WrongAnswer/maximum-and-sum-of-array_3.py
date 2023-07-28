class Solution:
    def maximumANDSum(self, nums: List[int], numSlots: int) -> int:
        
        nums.sort(reverse=True)
        def dfs(nums, numSlots, cur):
            if not nums:
                return cur
            if numSlots == 1:
                return cur + nums[0]
            if numSlots == 2:
                return cur + (nums[0] & nums[1])
            if numSlots == len(nums):
                return cur + sum(nums)
            if numSlots > len(nums):
                return cur + sum(nums)
            if numSlots == 3:
                return max(cur + (nums[0] & nums[1]), cur + (nums[0] & nums[2]), cur + (nums[1] & nums[2]))
            return max(dfs(nums[1:], numSlots-1, cur + (nums[0] & nums[1])), dfs(nums[1:], numSlots, cur))
        return dfs(nums, numSlots, 0)
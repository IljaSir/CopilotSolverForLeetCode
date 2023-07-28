class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        
        nums.sort()
        result = nums[0] + nums[1] + nums[2]
        for i in range(len(nums)):
            l, r = i + 1, len(nums) - 1
            while l < r:
                s = nums[i] + nums[l] + nums[r]
                if abs(s - target) < abs(result - target):
                    result = s
                if s < target:
                    l += 1
                else:
                    r -= 1
        return result
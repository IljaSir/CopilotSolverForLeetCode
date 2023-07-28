class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        
        if not nums:
            return []
        if k == 1:
            return nums
        if k == len(nums):
            return [max(nums)]
        res = []
        for i in range(len(nums) - k + 1):
            res.append(max(nums[i: i + k]))
        return res
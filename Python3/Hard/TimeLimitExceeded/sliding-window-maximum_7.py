class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        
        if not nums:
            return []
        if k == 1:
            return nums
        if k == len(nums):
            return [max(nums)]
        n = len(nums)
        result = []
        for i in range(n-k+1):
            result.append(max(nums[i:i+k]))
        return result
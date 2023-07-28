class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        
        if k == 1:
            return nums
        if k == len(nums):
            return [max(nums)]
        ans = []
        for i in range(len(nums)-k+1):
            ans.append(max(nums[i:i+k]))
        return ans
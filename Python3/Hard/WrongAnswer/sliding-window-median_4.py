class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        
        if k == 1:
            return nums
        if k == 2:
            return [sum(nums[:2])/2] + [sum(nums[i:i+2])/2 for i in range(1,len(nums)-1)] + [sum(nums[-2:])/2]
        if k == 3:
            return [sorted(nums[:3])[1]] + [sorted(nums[i:i+3])[1] for i in range(1,len(nums)-2)] + [sorted(nums[-3:])[1]]
        def get_median(nums):
            nums = sorted(nums)
            mid = len(nums) // 2
            return (nums[mid] + nums[~mid]) / 2
        return [get_median(nums[i:i+k]) for i in range(len(nums)-k+1)]
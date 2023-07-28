class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        
        if k == 1:
            return nums
        if k == len(nums):
            return [sorted(nums)[k//2] if k % 2 == 1 else sum(sorted(nums)[k//2-1:k//2+1])/2]
        res = []
        for i in range(len(nums)-k+1):
            res.append(sorted(nums[i:i+k])[k//2] if k % 2 == 1 else sum(sorted(nums[i:i+k])[k//2-1:k//2+1])/2)
        return res
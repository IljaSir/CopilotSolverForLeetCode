class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        
        n = len(nums)
        if n == 1:
            return nums[0]
        max_avg = sum(nums[0:k]) / k
        for i in range(1, n - k + 1):
            max_avg = max(max_avg, sum(nums[i:i + k]) / k)
        return max_avg
class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        
        n = len(nums)
        if n == 1:
            return nums[0]
        max_sum = sum(nums[:k])
        cur_sum = max_sum
        for i in range(1, n - k + 1):
            cur_sum = cur_sum - nums[i - 1] + nums[i + k - 1]
            max_sum = max(max_sum, cur_sum)
        return max_sum / k
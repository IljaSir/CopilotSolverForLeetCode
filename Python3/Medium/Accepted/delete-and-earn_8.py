class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        max_val = max(nums)
        sum_val = [0] * (max_val + 1)
        for num in nums:
            sum_val[num] += num
        take, skip = 0, 0
        for i in range(max_val + 1):
            take, skip = skip + sum_val[i], max(take, skip)
        return max(take, skip)
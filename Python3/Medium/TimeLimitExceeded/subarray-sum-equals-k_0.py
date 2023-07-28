class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        count = 0
        for i in range(len(nums)):
            sum = 0
            for j in range(i, len(nums)):
                sum += nums[j]
                if sum == k:
                    count += 1
        return count
class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        
        if k == 0:
            return any(nums[i]+nums[i+1] == 0 for i in range(len(nums)-1))
        else:
            return any(sum(nums[i:j]) % k == 0 for i in range(len(nums)) for j in range(i+2, len(nums)+1))
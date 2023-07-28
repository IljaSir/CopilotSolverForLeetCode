class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        
        nums = set(nums)
        max_k = -1
        for n in nums:
            if -n in nums:
                max_k = max(max_k, abs(n))
        return max_k
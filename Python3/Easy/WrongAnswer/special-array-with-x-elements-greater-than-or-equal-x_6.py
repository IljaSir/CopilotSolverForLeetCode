class Solution:
    def specialArray(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        if nums[0] >= n:
            return n
        for i in range(n-1):
            if nums[i] == nums[i+1]:
                continue
            if nums[i] >= n-i-1 and nums[i+1] < n-i-1:
                return n-i-1
        return -1
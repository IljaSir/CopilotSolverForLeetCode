class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        
        # O(n), O(1)
        n = len(nums)
        if n < 3:
            return 0
        res = 0
        for i in range(1, n-1):
            if nums[i-1] != nums[i] and nums[i+1] != nums[i]:
                if nums[i-1] < nums[i] and nums[i] > nums[i+1]:
                    res += 1
                elif nums[i-1] > nums[i] and nums[i] < nums[i+1]:
                    res += 1
        return res
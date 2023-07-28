class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return 0
        mx = nums[0]
        mn = nums[0]
        ans = nums[0]
        for i in range(1,len(nums)):
            mx, mn = max(nums[i], nums[i]*mx, nums[i]*mn), min(nums[i], nums[i]*mx, nums[i]*mn)
            ans = max(ans, mx)
        return ans
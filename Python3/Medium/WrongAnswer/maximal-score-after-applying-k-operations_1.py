class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
        
        if not nums:
            return 0
        if k == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == k:
            return sum(nums)
        nums.sort(reverse=True)
        # print(nums)
        # print(nums[:k])
        return sum(nums[:k])
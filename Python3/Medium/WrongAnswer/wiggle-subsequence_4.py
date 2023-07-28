class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        if len(nums) == 1:
            return 1
        if len(nums) == 2:
            return 2 if nums[0] != nums[1] else 1
        if nums[0] == nums[1]:
            return self.wiggleMaxLength(nums[1:])
        if nums[0] < nums[1]:
            return 1 + self.wiggleMaxLength([nums[0]] + [x for x in nums[2:] if x > nums[1]])
        return 1 + self.wiggleMaxLength([nums[0]] + [x for x in nums[2:] if x < nums[1]])
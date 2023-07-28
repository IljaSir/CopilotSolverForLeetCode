class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        # nums.sort()
        length = len(nums)
        if length == 1:
            return 1
        i = 0
        for j in range(1, length):
            if nums[i] != nums[j]:
                i += 1
                nums[i] = nums[j]
        return i + 1
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        i = 0
        for n in nums[1:]:
            if i < 1 or n > nums[i-1]:
                i += 1
                nums[i] = n
        return i + 1
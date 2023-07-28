class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        
        if not nums:
            return 0
        if val not in nums:
            return len(nums)
        i = 0
        for j in range(len(nums)):
            if nums[j] != val:
                nums[i] = nums[j]
                i += 1
        return i
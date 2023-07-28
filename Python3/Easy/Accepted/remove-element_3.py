class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        
        for i in range(len(nums)):
            if nums[i] == val:
                nums[i] = None
        while None in nums:
            nums.remove(None)
        return len(nums)
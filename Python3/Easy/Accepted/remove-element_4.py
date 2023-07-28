class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        
        # Solution 1 - 36 ms
        """
        for i in range(len(nums)-1, -1, -1):
            if nums[i] == val:
                nums.pop(i)
        return len(nums)
        """
        # Solution 2 - 32 ms
        i = 0
        for j in range(len(nums)):
            if nums[j] != val:
                nums[i] = nums[j]
                i += 1
        return i
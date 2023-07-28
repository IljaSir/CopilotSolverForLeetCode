class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        # 1. Count number of zeros
        # 2. Remove all zeros
        # 3. Add zeros to the end of the list
        # 4. Return the list
        count = 0
        for x in nums:
            if x == 0:
                count += 1
        for x in range(count):
            nums.remove(0)
        for x in range(count):
            nums.append(0)
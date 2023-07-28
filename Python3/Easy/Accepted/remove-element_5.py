class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        
        # Solution 1: Two Pointers
        # Time complexity: O(n)
        # Space complexity: O(1)
        # i = 0
        # for j in range(len(nums)):
        #     if nums[j] != val:
        #         nums[i] = nums[j]
        #         i += 1
        # return i
        # Solution 2: Two Pointers - when elements to remove are rare
        # Time complexity: O(n)
        # Space complexity: O(1)
        i = 0
        n = len(nums)
        while i < n:
            if nums[i] == val:
                nums[i] = nums[n - 1]
                n -= 1
            else:
                i += 1
        return n
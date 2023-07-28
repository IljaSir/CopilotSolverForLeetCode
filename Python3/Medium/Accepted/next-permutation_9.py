class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        # Runtime: 52 ms
        # Memory Usage: 14.3 MB
        # Time Complexity: O(n)
        # Space Complexity: O(1)
        # Solution: https://leetcode.com/problems/next-permutation/solution/
        # Algorithm: https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
        # 1. Find the largest index k such that nums[k] < nums[k + 1]. If no such index exists, just reverse nums and done.
        # 2. Find the largest index l greater than k such that nums[k] < nums[l].
        # 3. Swap the value of nums[k] with that of nums[l].
        # 4. Reverse the sequence from nums[k + 1] up to and including the final element nums[nums.size() - 1]
        k = -1
        for i in range(len(nums) - 2, -1, -1):
            if nums[i] < nums[i + 1]:
                k = i
                break
        if k == -1:
            nums.reverse()
            return
        l = -1
        for i in range(len(nums) - 1, k, -1):
            if nums[i] > nums[k]:
                l = i
                break
        nums[k], nums[l] = nums[l], nums[k]
        nums[k + 1:] = reversed(nums[k + 1:])
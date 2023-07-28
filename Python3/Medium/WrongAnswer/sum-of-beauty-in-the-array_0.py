class Solution:
    def sumOfBeauties(self, nums: List[int]) -> int:
        
        n = len(nums)
        left = [0] * n
        right = [0] * n
        left[0] = 1
        right[-1] = 1
        for i in range(1, n):
            left[i] = nums[i - 1] < nums[i] and left[i - 1]
        for i in range(n - 2, -1, -1):
            right[i] = nums[i] < nums[i + 1] and right[i + 1]
        res = 0
        for i in range(1, n - 1):
            if left[i] and right[i]:
                res += 2
            elif nums[i - 1] < nums[i] < nums[i + 1]:
                res += 1
        return res
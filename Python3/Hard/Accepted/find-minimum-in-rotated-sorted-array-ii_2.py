class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n == 1:
            return nums[0]
        if nums[0] < nums[n - 1]:
            return nums[0]
        left, right = 0, n - 1
        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[right]:
                left = mid + 1
            elif nums[mid] < nums[right]:
                right = mid
            else:
                right -= 1
        return nums[left]
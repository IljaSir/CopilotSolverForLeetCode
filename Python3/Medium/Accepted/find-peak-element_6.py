class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        # O(n)
        # for i in range(1, len(nums)-1):
        #     if nums[i] > nums[i-1] and nums[i] > nums[i+1]:
        #         return i
        # if nums[0] > nums[1]:
        #     return 0
        # if nums[-1] > nums[-2]:
        #     return len(nums) - 1
        
        # O(logn)
        # binary search
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = (left + right) // 2
            if nums[mid] < nums[mid+1]:
                left = mid + 1
            else:
                right = mid
        return left
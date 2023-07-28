class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        # binary search
        n = len(nums)
        l, r = 0, n-1
        while l <= r:
            mid = (l+r)//2
            if mid > 0 and mid < n-1:
                if nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1]:
                    return mid
                elif nums[mid] < nums[mid-1]:
                    r = mid-1
                else:
                    l = mid+1
            elif mid == 0:
                if nums[mid] > nums[mid+1]:
                    return mid
                else:
                    l = mid+1
            elif mid == n-1:
                if nums[mid] > nums[mid-1]:
                    return mid
                else:
                    r = mid-1
        return -1
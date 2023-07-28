class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n == 1:
            return nums[0]
        mid = n // 2
        if mid == 0:
            return nums[mid]
        if mid % 2 == 0:
            if nums[mid] == nums[mid-1]:
                return self.singleNonDuplicate(nums[mid+1:])
            else:
                return self.singleNonDuplicate(nums[:mid])
        else:
            if nums[mid] == nums[mid-1]:
                return self.singleNonDuplicate(nums[:mid-1])
            else:
                return self.singleNonDuplicate(nums[mid+1:])
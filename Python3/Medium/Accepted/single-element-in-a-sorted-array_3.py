class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n == 1:
            return nums[0]
        if nums[0] != nums[1]:
            return nums[0]
        if nums[n-1] != nums[n-2]:
            return nums[n-1]
        l, r = 0, n-1
        while l <= r:
            m = (l + r) // 2
            if nums[m] != nums[m-1] and nums[m] != nums[m+1]:
                return nums[m]
            if m % 2 == 0:
                if nums[m] == nums[m-1]:
                    r = m-2
                else:
                    l = m+2
            else:
                if nums[m] == nums[m-1]:
                    l = m+1
                else:
                    r = m-1
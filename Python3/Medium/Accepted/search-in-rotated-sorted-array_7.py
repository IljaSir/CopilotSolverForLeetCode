class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        if not nums:
            return -1
        if len(nums)==1:
            return 0 if target==nums[0] else -1
        l, r = 0, len(nums)-1
        while l<=r:
            m = (l+r)//2
            if nums[m]==target:
                return m
            if nums[m]>=nums[l]:
                if target>=nums[l] and target<nums[m]:
                    r = m-1
                else:
                    l = m+1
            else:
                if target>nums[m] and target<=nums[r]:
                    l = m+1
                else:
                    r = m-1
        return -1
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if not nums:
            return [-1, -1]
        if target < nums[0] or target > nums[-1]:
            return [-1, -1]
        l, r = 0, len(nums) - 1
        while l <= r:
            m = (l + r) // 2
            if nums[m] == target:
                l, r = m, m
                while l >= 0 and nums[l] == target:
                    l -= 1
                while r < len(nums) and nums[r] == target:
                    r += 1
                return [l + 1, r - 1]
            elif nums[m] < target:
                l = m + 1
            else:
                r = m - 1
        return [-1, -1]
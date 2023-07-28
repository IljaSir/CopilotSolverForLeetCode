class Solution:
    def validSubarraySize(self, nums: List[int], threshold: int) -> int:
        
        l, r = 0, len(nums)
        while l < r:
            mid = (l + r) // 2
            if self.valid(nums, mid, threshold):
                r = mid
            else:
                l = mid + 1
        return r if self.valid(nums, r, threshold) else -1
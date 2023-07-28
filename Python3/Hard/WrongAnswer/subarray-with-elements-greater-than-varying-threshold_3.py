class Solution:
    def validSubarraySize(self, nums: List[int], threshold: int) -> int:
        
        def valid(size):
            return sum(nums[i] for i in range(size)) > threshold
        
        lo, hi = 1, len(nums)
        while lo < hi:
            mid = (lo + hi) // 2
            if valid(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo if valid(lo) else -1
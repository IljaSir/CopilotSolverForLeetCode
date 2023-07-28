class Solution:
    def validSubarraySize(self, nums: List[int], threshold: int) -> int:
        
        def valid(k):
            return sum([max(0, nums[i] - (threshold // k)) for i in range(k)]) <= threshold % k
        lo, hi = 1, len(nums)
        while lo < hi:
            mi = (lo + hi) // 2
            if valid(mi):
                hi = mi
            else:
                lo = mi + 1
        return lo if valid(lo) else -1
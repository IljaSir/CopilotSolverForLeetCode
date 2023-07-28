class Solution:
    def validSubarraySize(self, nums: List[int], threshold: int) -> int:
        
        def is_valid(k):
            return sum(nums[i] for i in range(k)) > threshold * k
        n = len(nums)
        if not is_valid(n):
            return -1
        l, r = 1, n
        while l < r:
            m = l + (r - l) // 2
            if is_valid(m):
                r = m
            else:
                l = m + 1
        return l
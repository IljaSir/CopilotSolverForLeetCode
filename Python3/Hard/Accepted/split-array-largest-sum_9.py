class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        
        def split(nums, largest):
            n = 1
            s = 0
            for num in nums:
                s += num
                if s > largest:
                    s = num
                    n += 1
            return n
        
        lo = max(nums)
        hi = sum(nums)
        while lo < hi:
            mid = (lo + hi) // 2
            n = split(nums, mid)
            if n > k:
                lo = mid + 1
            else:
                hi = mid
        return lo
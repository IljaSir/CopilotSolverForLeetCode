class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        
        nums.sort()
        n = len(nums)
        lo, hi = 0, nums[-1] - nums[0]
        while lo < hi:
            mi = (lo + hi) // 2
            count = 0
            for i in range(n):
                j = i
                while j < n and nums[j] - nums[i] <= mi:
                    j += 1
                count += j - i - 1
            if count >= k:
                hi = mi
            else:
                lo = mi + 1
        return lo
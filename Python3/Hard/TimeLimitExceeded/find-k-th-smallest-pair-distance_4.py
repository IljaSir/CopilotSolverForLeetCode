class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        
        nums.sort()
        l, r = 0, nums[-1] - nums[0]
        while l < r:
            m = (l + r) // 2
            cnt = 0
            for i in range(len(nums)):
                j = i
                while j < len(nums) and nums[j] - nums[i] <= m:
                    j += 1
                cnt += j - i - 1
            if cnt < k:
                l = m + 1
            else:
                r = m
        return l
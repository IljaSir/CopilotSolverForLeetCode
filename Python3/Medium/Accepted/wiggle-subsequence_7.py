class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        
        if len(nums) < 2:
            return len(nums)
        diffs = [nums[i] - nums[i-1] for i in range(1, len(nums))]
        diffs = [d for d in diffs if d != 0]
        if len(diffs) == 0:
            return 1
        ans = 2
        sign = diffs[0] / abs(diffs[0])
        for i in range(1, len(diffs)):
            if diffs[i] / abs(diffs[i]) != sign:
                ans += 1
                sign = diffs[i] / abs(diffs[i])
        return ans
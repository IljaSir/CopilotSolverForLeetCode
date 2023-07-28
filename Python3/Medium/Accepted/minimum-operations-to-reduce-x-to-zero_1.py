class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        
        total = sum(nums)
        target = total - x
        if target < 0: return -1
        if target == 0: return len(nums)
        start, end, res, cur = 0, 0, float('inf'), 0
        while end < len(nums):
            cur += nums[end]
            while cur > target:
                cur -= nums[start]
                start += 1
            if cur == target:
                res = min(res, len(nums) - (end - start + 1))
            end += 1
        return res if res != float('inf') else -1
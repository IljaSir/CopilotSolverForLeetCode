class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        
        def count(x):
            ans = cur = 0
            for num in nums:
                cur = cur + 1 if num <= x else 0
                ans += cur
            return ans
        return count(right) - count(left - 1)
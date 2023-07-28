class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        
        def count(bound):
            ans = cur = 0
            for x in nums:
                cur = cur + 1 if x <= bound else 0
                ans += cur
            return ans

        return count(right) - count(left - 1)
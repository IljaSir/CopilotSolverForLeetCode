class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        
        # find the number of subarray with max in [left, right]
        # then find the number of subarray with max in [0, left-1]
        # then the answer is the first minus the second
        def count(maximum):
            ans = cur = 0
            for x in nums:
                cur = cur + 1 if x <= maximum else 0
                ans += cur
            return ans
        return count(right) - count(left - 1)
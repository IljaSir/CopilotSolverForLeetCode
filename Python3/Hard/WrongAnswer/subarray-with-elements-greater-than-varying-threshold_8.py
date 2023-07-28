class Solution:
    def validSubarraySize(self, nums: List[int], threshold: int) -> int:
        
        def check(k):
            return sum(nums[:k]) > threshold * k
        l = 0
        r = len(nums) + 1
        while l < r:
            mid = (l + r) // 2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l if l < len(nums) else -1
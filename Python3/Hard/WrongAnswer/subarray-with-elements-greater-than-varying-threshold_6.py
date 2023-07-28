class Solution:
    def validSubarraySize(self, nums: List[int], threshold: int) -> int:
        
        
        def is_valid(k):
            return sum(nums[i] for i in range(k)) >= threshold * k
        
        if not is_valid(1):
            return -1
        
        left, right = 1, len(nums)
        while left < right:
            mid = (left + right) // 2
            if is_valid(mid):
                right = mid
            else:
                left = mid + 1
        
        return left
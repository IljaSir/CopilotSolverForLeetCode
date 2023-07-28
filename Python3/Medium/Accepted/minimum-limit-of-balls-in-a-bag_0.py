class Solution:
    def minimumSize(self, nums: List[int], maxOperations: int) -> int:
        
        
        def check(mid):
            count = 0
            for num in nums:
                count += (num - 1) // mid
            return count <= maxOperations
        
        left, right = 1, max(nums)
        while left < right:
            mid = left + (right - left) // 2
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return left
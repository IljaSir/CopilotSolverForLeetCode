class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        
        # nums = [2,1,4,3], left = 2, right = 3
        # [2], [2, 1], [3]
        # [2, 1, 4], [1, 4, 3], [4, 3]
        # [2, 1, 4, 3]
        # [1, 4], [4, 3]
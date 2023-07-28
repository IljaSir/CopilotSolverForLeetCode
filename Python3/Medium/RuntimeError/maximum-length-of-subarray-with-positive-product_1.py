class Solution:
    def getMaxLen(self, nums: List[int]) -> int:
        
        # 1. Find the longest subarray with positive product
        # 2. Find the longest subarray with negative product
        # 3. Return the maximum of 1 and 2
        # 4. If there is no positive product, return 0
        # 5. If there is no negative product, return the longest subarray with positive product
        # 6. If there is no positive product, return the longest subarray with negative product
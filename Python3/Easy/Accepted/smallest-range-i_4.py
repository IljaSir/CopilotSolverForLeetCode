class Solution:
    def smallestRangeI(self, nums: List[int], k: int) -> int:
        
        max_num = max(nums)
        min_num = min(nums)
        return max(0, max_num - min_num - 2 * k)
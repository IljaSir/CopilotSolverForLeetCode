class Solution:
    def kthLargestNumber(self, nums: List[str], k: int) -> str:
        
        return sorted(nums, key=int, reverse=True)[k-1]
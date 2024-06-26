class Solution:
    def kthLargestNumber(self, nums: List[str], k: int) -> str:
        
        return sorted(nums, key=lambda x: int(x), reverse=True)[k-1]
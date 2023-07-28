class Solution:
    def kthLargestNumber(self, nums: List[str], k: int) -> str:
        
        nums = [int(n) for n in nums]
        nums.sort(reverse=True)
        return str(nums[k-1])
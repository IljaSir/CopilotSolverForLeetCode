class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        
        return [nums[i] for i in range(0, n)] + [nums[i] for i in range(n, len(nums))]
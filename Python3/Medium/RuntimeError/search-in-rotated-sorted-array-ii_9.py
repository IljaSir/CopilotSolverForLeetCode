class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        
        if not nums:
            return False
        return self.searchHelper(nums, target, 0, len(nums) - 1)
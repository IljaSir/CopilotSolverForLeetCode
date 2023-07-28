class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        
        return [nums[i] for i in range(n) for j in range(2)]
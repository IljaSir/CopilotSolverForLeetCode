class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        
        return [nums[i] for i in range(n)] + [nums[i] for i in range(n, 2*n)]
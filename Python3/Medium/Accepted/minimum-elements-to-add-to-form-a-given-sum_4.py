class Solution:
    def minElements(self, nums: List[int], limit: int, goal: int) -> int:
        
        return int(math.ceil(abs(goal - sum(nums)) / limit))
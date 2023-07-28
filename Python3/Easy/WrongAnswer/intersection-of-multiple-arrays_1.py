class Solution:
    def intersection(self, nums: List[List[int]]) -> List[int]:
        
        return list(set.intersection(*map(set, nums)))
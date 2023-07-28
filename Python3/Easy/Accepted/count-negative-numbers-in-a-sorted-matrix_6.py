class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        
        return sum([len([1 for i in row if i < 0]) for row in grid])
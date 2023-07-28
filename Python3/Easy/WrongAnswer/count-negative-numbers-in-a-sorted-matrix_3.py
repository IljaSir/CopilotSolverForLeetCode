class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        
        
        # count = 0
        # for row in grid:
        #     for item in row:
        #         if item < 0:
        #             count += 1
        # return count
        
        # return sum([sum([1 for item in row if item < 0]) for row in grid])
        
        return sum([bisect.bisect_left(row, 0) for row in grid])
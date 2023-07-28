class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        
        horizontalCuts.sort()
        verticalCuts.sort()
        horizontalCuts = [0] + horizontalCuts + [h]
        verticalCuts = [0] + verticalCuts + [w]
        max_width = max([horizontalCuts[i + 1] - horizontalCuts[i] for i in range(len(horizontalCuts) - 1)])
        max_height = max([verticalCuts[i + 1] - verticalCuts[i] for i in range(len(verticalCuts) - 1)])
        return (max_width * max_height) % (10**9 + 7)
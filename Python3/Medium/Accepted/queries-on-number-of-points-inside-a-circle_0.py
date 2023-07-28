class Solution:
    def countPoints(self, points: List[List[int]], queries: List[List[int]]) -> List[int]:
        
        ans = []
        for x, y, r in queries:
            ans.append(sum((x - a) ** 2 + (y - b) ** 2 <= r ** 2 for a, b in points))
        return ans
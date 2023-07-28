class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        
        items.sort()
        res = []
        for q in queries:
            i = bisect.bisect(items, [q+1, 0]) - 1
            res.append(max([0] + [items[i][1] for i in range(i+1)]))
        return res
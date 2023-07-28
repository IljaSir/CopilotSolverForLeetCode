class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        
        items.sort(key = lambda x: x[0])
        for i in range(1, len(items)):
            items[i][1] = max(items[i][1], items[i-1][1])
        res = []
        for q in queries:
            i = bisect.bisect(items, [q+1, 0])
            if i == 0:
                res.append(0)
            else:
                res.append(items[i-1][1])
        return res
class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        
        queries.sort()
        items.sort(key = lambda x: x[0])
        res = []
        maxBeauty = 0
        i = 0
        for query in queries:
            while i < len(items) and items[i][0] <= query:
                maxBeauty = max(maxBeauty, items[i][1])
                i += 1
            res.append(maxBeauty)
        return res
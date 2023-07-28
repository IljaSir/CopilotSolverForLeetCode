class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        
        
        items = sorted(items, key=lambda x: x[0])
        n = len(items)
        max_beauty = [0] * n
        max_beauty[0] = items[0][1]
        for i in range(1, n):
            max_beauty[i] = max(max_beauty[i-1], items[i][1])
            
        res = []
        for query in queries:
            idx = bisect.bisect_right(items, [query, float('inf')])
            if idx == 0:
                res.append(0)
            else:
                res.append(max_beauty[idx-1])
        return res
class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        
        items.sort(key = lambda x: x[1], reverse = True)
        res = []
        for q in queries:
            max_beauty = 0
            for p, b in items:
                if p <= q:
                    max_beauty = max(max_beauty, b)
                else:
                    break
            res.append(max_beauty)
        return res
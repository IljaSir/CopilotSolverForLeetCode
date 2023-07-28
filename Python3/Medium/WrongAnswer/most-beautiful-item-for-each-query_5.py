class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        
        items.sort()
        items = list(map(lambda x: x[1], items))
        for i in range(1, len(items)):
            items[i] = max(items[i], items[i-1])
        return [items[bisect.bisect_right(items, q) - 1] for q in queries]
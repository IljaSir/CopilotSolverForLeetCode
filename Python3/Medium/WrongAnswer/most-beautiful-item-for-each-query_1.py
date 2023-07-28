class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        
        items.sort()
        items = [[0,0]] + items
        for i in range(1, len(items)):
            items[i][1] += items[i-1][1]
        ans = []
        for q in queries:
            i = bisect.bisect_right(items, [q, float('inf')])
            ans.append(items[i-1][1])
        return ans
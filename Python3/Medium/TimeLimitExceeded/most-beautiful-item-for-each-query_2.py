class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        
        items.sort(key=lambda x: x[0])
        ans = []
        for q in queries:
            max_b = 0
            for p, b in items:
                if p > q:
                    break
                max_b = max(max_b, b)
            ans.append(max_b)
        return ans
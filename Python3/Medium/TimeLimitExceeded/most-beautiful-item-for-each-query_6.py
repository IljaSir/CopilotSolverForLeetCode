class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        
        items.sort(key=lambda x: x[1], reverse=True)
        items.sort(key=lambda x: x[0])
        ans = []
        for q in queries:
            tmp = 0
            for i in items:
                if i[0] <= q:
                    tmp = max(tmp, i[1])
                else:
                    break
            ans.append(tmp)
        return ans
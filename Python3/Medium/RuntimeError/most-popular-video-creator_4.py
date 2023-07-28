class Solution:
    def mostPopularCreator(self, creators: List[str], ids: List[str], views: List[int]) -> List[List[str]]:
        
        res = {}
        for i in range(len(creators)):
            if creators[i] not in res:
                res[creators[i]] = {}
            if ids[i] not in res[creators[i]]:
                res[creators[i]][ids[i]] = 0
            res[creators[i]][ids[i]] += views[i]
        max_views = 0
        for c in res:
            max_views = max(max_views, sum(res[c].values()))
        ans = []
        for c in res:
            if sum(res[c].values()) == max_views:
                max_id = min(res[c].keys(), key=lambda x: (res[c][x], x), reverse=True)
                ans.append([c, max_id])
        return ans
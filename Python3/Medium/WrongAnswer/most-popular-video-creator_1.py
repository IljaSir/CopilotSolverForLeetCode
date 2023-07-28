class Solution:
    def mostPopularCreator(self, creators: List[str], ids: List[str], views: List[int]) -> List[List[str]]:
        
        d = {}
        for i in range(len(creators)):
            if creators[i] not in d:
                d[creators[i]] = [(ids[i], views[i])]
            else:
                d[creators[i]].append((ids[i], views[i]))
        # print(d)
        max_views = 0
        res = []
        for k, v in d.items():
            views = 0
            for vid in v:
                views += vid[1]
            if views > max_views:
                max_views = views
                res = []
                res.append(k)
            elif views == max_views:
                res.append(k)
        # print(res)
        ans = []
        for r in res:
            ans.append([r, max(d[r], key=lambda x: x[1])[0]])
        return ans
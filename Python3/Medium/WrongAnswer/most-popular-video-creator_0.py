class Solution:
    def mostPopularCreator(self, creators: List[str], ids: List[str], views: List[int]) -> List[List[str]]:
        
        d = {}
        for i in range(len(creators)):
            if creators[i] not in d:
                d[creators[i]] = [(ids[i], views[i])]
            else:
                d[creators[i]].append((ids[i], views[i]))
        max_views = 0
        res = []
        for key in d:
            views = 0
            max_id = ""
            for id, view in d[key]:
                if view > views:
                    views = view
                    max_id = id
                elif view == views:
                    if id < max_id:
                        max_id = id
            if views > max_views:
                max_views = views
                res = [[key, max_id]]
            elif views == max_views:
                res.append([key, max_id])
        return res
class Solution:
    def mostPopularCreator(self, creators: List[str], ids: List[str], views: List[int]) -> List[List[str]]:
        
        d = {}
        for i in range(len(creators)):
            if creators[i] not in d:
                d[creators[i]] = [[ids[i], views[i]]]
            else:
                d[creators[i]].append([ids[i], views[i]])
        max_views = 0
        max_creators = []
        for creator in d:
            view = sum([i[1] for i in d[creator]])
            if view > max_views:
                max_views = view
                max_creators = [creator]
            elif view == max_views:
                max_creators.append(creator)
        ans = []
        for creator in max_creators:
            max_id = min([i[0] for i in d[creator]])
            ans.append([creator, max_id])
        return ans
class Solution:
    def mostPopularCreator(self, creators: List[str], ids: List[str], views: List[int]) -> List[List[str]]:
        
        d = {}
        for i in range(len(creators)):
            if creators[i] not in d:
                d[creators[i]] = (ids[i], views[i])
            else:
                if views[i] > d[creators[i]][1]:
                    d[creators[i]] = (ids[i], views[i])
                elif views[i] == d[creators[i]][1]:
                    if ids[i] < d[creators[i]][0]:
                        d[creators[i]] = (ids[i], views[i])
        ans = []
        for k, v in d.items():
            ans.append([k, v[0]])
        return ans
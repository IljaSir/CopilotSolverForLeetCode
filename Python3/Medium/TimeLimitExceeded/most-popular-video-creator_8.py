class Solution:
    def mostPopularCreator(self, creators: List[str], ids: List[str], views: List[int]) -> List[List[str]]:
        
        d = {}
        for i in range(len(creators)):
            d[creators[i]] = d.get(creators[i], []) + [(ids[i], views[i])]
        max_pop = max([sum([v for _, v in d[k]]) for k in d])
        res = []
        for k in d:
            if sum([v for _, v in d[k]]) == max_pop:
                res.append([k, min([i for i, v in d[k] if v == max([v for _, v in d[k]])])])
        return res
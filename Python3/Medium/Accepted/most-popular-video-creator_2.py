class Solution:
    def mostPopularCreator(self, creators: List[str], ids: List[str], views: List[int]) -> List[List[str]]:
        
        d = {}
        for i in range(len(creators)):
            if creators[i] not in d:
                d[creators[i]] = {}
            if ids[i] not in d[creators[i]]:
                d[creators[i]][ids[i]] = 0
            d[creators[i]][ids[i]] += views[i]
        max_views = 0
        res = []
        for creator in d:
            max_views = max(max_views, sum(d[creator].values()))
        for creator in d:
            if sum(d[creator].values()) == max_views:
                res.append([creator, sorted(d[creator].keys(), key=lambda x: (-d[creator][x], x))[0]])
        return res
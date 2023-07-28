class Solution:
    def mostPopularCreator(self, creators: List[str], ids: List[str], views: List[int]) -> List[List[str]]:
        
        from collections import defaultdict
        d = defaultdict(list)
        for creator, id, view in zip(creators, ids, views):
            d[creator].append((id, view))
        max_pop = 0
        res = []
        for creator, id_views in d.items():
            pop = sum(view for id, view in id_views)
            max_pop = max(pop, max_pop)
            res.append([creator, max(id_views, key=lambda x: x[1])[0]])
        return [r for r in res if sum(r[1:]) == max_pop]
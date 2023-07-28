class Solution:
    def processQueries(self, queries: List[int], m: int) -> List[int]:
        
        p = list(range(1, m+1))
        res = []
        for q in queries:
            idx = p.index(q)
            res.append(idx)
            p = [q] + p[:idx] + p[idx+1:]
        return res
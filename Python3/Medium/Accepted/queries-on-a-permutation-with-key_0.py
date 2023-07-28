class Solution:
    def processQueries(self, queries: List[int], m: int) -> List[int]:
        
        p = list(range(1, m+1))
        res = []
        for q in queries:
            i = p.index(q)
            res.append(i)
            p = [q] + p[:i] + p[i+1:]
        return res
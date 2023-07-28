class Solution:
    def processQueries(self, queries: List[int], m: int) -> List[int]:
        
        p = [i for i in range(1, m + 1)]
        ans = []
        for i in queries:
            for j in range(len(p)):
                if p[j] == i:
                    ans.append(j)
                    p.insert(0, p.pop(j))
                    break
        return ans
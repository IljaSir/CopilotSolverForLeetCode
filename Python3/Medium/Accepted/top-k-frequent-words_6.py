class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        
        d = {}
        for w in words:
            if w in d:
                d[w] += 1
            else:
                d[w] = 1
        res = []
        for w in d:
            if len(res) < k:
                res.append((w, d[w]))
            else:
                res.sort(key=lambda x: (-x[1], x[0]))
                if res[k-1][1] < d[w]:
                    res[k-1] = (w, d[w])
                elif res[k-1][1] == d[w]:
                    if res[k-1][0] > w:
                        res[k-1] = (w, d[w])
        res.sort(key=lambda x: (-x[1], x[0]))
        return [x[0] for x in res]
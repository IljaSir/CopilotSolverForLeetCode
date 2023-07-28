class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        
        d = collections.defaultdict(list)
        for i, c in enumerate(s):
            d[c].append(i)
        res = 0
        for w in words:
            i = 0
            for c in w:
                if c not in d:
                    break
                if i == len(d[c]):
                    break
                i = bisect.bisect_right(d[c], i)
            else:
                res += 1
        return res
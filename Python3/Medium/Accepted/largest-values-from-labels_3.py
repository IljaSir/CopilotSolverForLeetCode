class Solution:
    def largestValsFromLabels(self, values: List[int], labels: List[int], numWanted: int, useLimit: int) -> int:
        
        from collections import Counter
        a = sorted(zip(values, labels), key=lambda x: x[0], reverse=True)
        c = Counter()
        res = 0
        for v, l in a:
            if c[l] < useLimit:
                res += v
                c[l] += 1
                numWanted -= 1
            if numWanted == 0:
                break
        return res
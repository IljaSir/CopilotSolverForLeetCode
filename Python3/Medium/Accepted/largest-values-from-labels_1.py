class Solution:
    def largestValsFromLabels(self, values: List[int], labels: List[int], numWanted: int, useLimit: int) -> int:
        
        items = sorted(zip(values, labels), key=lambda x: x[0], reverse=True)
        used = collections.Counter()
        res = 0
        for v, l in items:
            if numWanted == 0:
                break
            if used[l] < useLimit:
                res += v
                used[l] += 1
                numWanted -= 1
        return res
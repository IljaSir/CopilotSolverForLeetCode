class Solution:
    def largestValsFromLabels(self, values: List[int], labels: List[int], numWanted: int, useLimit: int) -> int:
        
        labels = [(value, label) for value, label in zip(values, labels)]
        labels.sort(reverse=True)
        count = collections.defaultdict(int)
        res = 0
        for value, label in labels:
            if count[label] < useLimit:
                res += value
                count[label] += 1
                numWanted -= 1
                if numWanted == 0:
                    break
        return res
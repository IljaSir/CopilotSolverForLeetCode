class Solution:
    def largestValsFromLabels(self, values: List[int], labels: List[int], numWanted: int, useLimit: int) -> int:
        
        # values, labels = zip(*sorted(zip(values, labels), reverse=True))
        values, labels = zip(*sorted(zip(values, labels), key=lambda x: x[0], reverse=True))
        label_count = {}
        res = 0
        for i in range(len(values)):
            if numWanted == 0:
                break
            if labels[i] not in label_count:
                label_count[labels[i]] = 1
                res += values[i]
                numWanted -= 1
            else:
                if label_count[labels[i]] < useLimit:
                    label_count[labels[i]] += 1
                    res += values[i]
                    numWanted -= 1
        return res
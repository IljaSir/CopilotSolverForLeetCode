class Solution:
    def largestValsFromLabels(self, values: List[int], labels: List[int], numWanted: int, useLimit: int) -> int:
        
        pairs = sorted(zip(values, labels), reverse=True)
        score = 0
        label_count = {}
        for value, label in pairs:
            if numWanted == 0:
                break
            if label not in label_count:
                label_count[label] = 0
            if label_count[label] < useLimit:
                label_count[label] += 1
                numWanted -= 1
                score += value
        return score
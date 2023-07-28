class Solution:
    def largestValsFromLabels(self, values: List[int], labels: List[int], numWanted: int, useLimit: int) -> int:
        
        n = len(values)
        items = list(zip(values, labels))
        items.sort(reverse=True)
        used = collections.defaultdict(int)
        ans = 0
        for val, label in items:
            if numWanted <= 0:
                break
            if used[label] < useLimit:
                ans += val
                used[label] += 1
                numWanted -= 1
        return ans
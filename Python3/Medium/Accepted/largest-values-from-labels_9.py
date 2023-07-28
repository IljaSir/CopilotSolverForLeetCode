class Solution:
    def largestValsFromLabels(self, values: List[int], labels: List[int], numWanted: int, useLimit: int) -> int:
        
        # sort by value
        v = sorted(zip(values, labels), key=lambda x: x[0], reverse=True)
        # count labels
        c = collections.Counter()
        # sum values
        s = 0
        # for each value
        for value, label in v:
            # if we can still take numWanted
            if numWanted > 0:
                # if we can still take useLimit
                if c[label] < useLimit:
                    # take it
                    s += value
                    c[label] += 1
                    numWanted -= 1
            else:
                break
        return s
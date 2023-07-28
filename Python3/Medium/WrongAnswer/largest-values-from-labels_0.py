class Solution:
    def largestValsFromLabels(self, values: List[int], labels: List[int], numWanted: int, useLimit: int) -> int:
        
        d = {}
        for i in range(len(values)):
            if labels[i] not in d:
                d[labels[i]] = []
            d[labels[i]].append(values[i])
        for k in d:
            d[k].sort(reverse=True)
        
        res = 0
        while numWanted > 0:
            max_val = 0
            max_label = 0
            for k in d:
                if len(d[k]) > 0:
                    if d[k][0] > max_val:
                        max_val = d[k][0]
                        max_label = k
            if max_val > 0:
                res += max_val
                d[max_label].pop(0)
                numWanted -= 1
                useLimit -= 1
                if useLimit == 0:
                    for k in d:
                        if k != max_label:
                            d[k] = []
            else:
                break
        return res
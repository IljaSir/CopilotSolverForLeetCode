class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        
        d = {}
        for i, j in dominoes:
            if (i, j) in d:
                d[(i, j)] += 1
            elif (j, i) in d:
                d[(j, i)] += 1
            else:
                d[(i, j)] = 1
        return sum([v * (v - 1) // 2 for v in d.values()])
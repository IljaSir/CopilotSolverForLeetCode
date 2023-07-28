class Solution:
    def canCross(self, stones: List[int]) -> bool:
        
        if not stones:
            return False
        if stones[1] != 1:
            return False
        if len(stones) == 2:
            return True
        d = collections.defaultdict(set)
        d[1].add(1)
        for i in range(1, len(stones)):
            for j in d[stones[i]]:
                for k in range(j-1, j+2):
                    if k <= 0:
                        continue
                    if stones[i] + k in d:
                        d[stones[i] + k].add(k)
                    else:
                        d[stones[i] + k] = set([k])
        return len(d[stones[-1]]) != 0
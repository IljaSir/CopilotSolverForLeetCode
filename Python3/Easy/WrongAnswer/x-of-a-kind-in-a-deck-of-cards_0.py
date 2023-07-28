class Solution:
    def hasGroupsSizeX(self, deck: List[int]) -> bool:
        
        if len(deck) == 1:
            return False
        d = {}
        for i in deck:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1
        v = list(d.values())
        if len(v) == 1:
            return True
        if len(v) == 2:
            return v[0] == v[1]
        if len(v) > 2:
            for i in range(2, max(v)+1):
                if sum([v[j] % i for j in range(len(v))]) == 0:
                    return True
            return False
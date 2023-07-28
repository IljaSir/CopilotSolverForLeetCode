class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        
        d = {}
        for i in ideas:
            for j in ideas:
                if i != j:
                    d[i[0]+j[1:]] = 1
                    d[j[0]+i[1:]] = 1
        return len(d)
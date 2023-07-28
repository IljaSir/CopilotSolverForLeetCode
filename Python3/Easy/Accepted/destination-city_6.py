class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        
        return list(set([i[1] for i in paths]) - set([i[0] for i in paths]))[0]
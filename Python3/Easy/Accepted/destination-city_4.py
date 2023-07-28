class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        
        start_set = set()
        end_set = set()
        for path in paths:
            start_set.add(path[0])
            end_set.add(path[1])
        return list(end_set - start_set)[0]
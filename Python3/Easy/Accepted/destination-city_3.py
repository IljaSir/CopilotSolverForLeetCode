class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        
        start, end = set(), set()
        for path in paths:
            start.add(path[0])
            end.add(path[1])
        return (end - start).pop()
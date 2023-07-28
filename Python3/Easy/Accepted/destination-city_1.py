class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        
        from_city = set()
        to_city = set()
        for path in paths:
            from_city.add(path[0])
            to_city.add(path[1])
        return (to_city - from_city).pop()
class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        
        d1 = {x: i for i, x in enumerate(list1)}
        d2 = {x: i for i, x in enumerate(list2)}
        d = {}
        for key, value in d1.items():
            if key in d2:
                d[key] = value + d2[key]
        min_value = min(d.values())
        return [key for key, value in d.items() if value == min_value]
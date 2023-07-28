class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        
        dict1 = {list1[i]: i for i in range(len(list1))}
        dict2 = {list2[i]: i for i in range(len(list2))}
        dict3 = {}
        for key, val in dict1.items():
            if key in dict2:
                dict3[key] = val + dict2[key]
        min_val = min(dict3.values())
        return [key for key, val in dict3.items() if val == min_val]
class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        
        common = set(list1).intersection(set(list2))
        common = sorted(common, key=lambda x: list1.index(x) + list2.index(x))
        min_sum = list1.index(common[0]) + list2.index(common[0])
        return [x for x in common if list1.index(x) + list2.index(x) == min_sum]
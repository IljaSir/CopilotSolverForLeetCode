class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        
        arr2_dict = {}
        for i in range(len(arr2)):
            arr2_dict[arr2[i]] = i
        arr1.sort(key=lambda x: arr2_dict.get(x, x + 1001))
        return arr1
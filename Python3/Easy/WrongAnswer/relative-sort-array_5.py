class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        
        arr1.sort()
        arr2.sort()
        arr2 = set(arr2)
        res = []
        for i in arr1:
            if i in arr2:
                res.append(i)
        for i in arr1:
            if i not in arr2:
                res.append(i)
        return res
class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        
        arr1.sort()
        arr2.sort()
        arr1 = list(reversed(arr1))
        arr2 = list(reversed(arr2))
        res = []
        while arr2:
            while arr1 and arr1[-1] == arr2[-1]:
                res.append(arr1.pop())
            arr2.pop()
        while arr1:
            res.append(arr1.pop())
        return res
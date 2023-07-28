class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        
        arr1.sort()
        arr2.sort()
        arr2 = arr2[::-1]
        for i in arr2:
            while i in arr1:
                arr1.remove(i)
                arr1.insert(0, i)
        return arr1
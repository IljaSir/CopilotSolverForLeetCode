class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        
        arr1.sort()
        arr2.sort()
        result = []
        for i in arr2:
            for j in arr1:
                if i == j:
                    result.append(j)
        for i in arr1:
            if i not in result:
                result.append(i)
        return result
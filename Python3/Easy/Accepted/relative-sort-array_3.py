class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        
        map = {}
        for i in range(0, len(arr1)):
            map[arr1[i]] = map.get(arr1[i], 0) + 1
        result = []
        for j in range(0, len(arr2)):
            if map[arr2[j]] > 0:
                result.extend([arr2[j]] * map[arr2[j]])
                map[arr2[j]] = 0
        for k in range(0, 1001):
            if map.get(k, 0) > 0:
                result.extend([k] * map[k])
        return result
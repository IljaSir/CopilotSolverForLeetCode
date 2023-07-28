class Solution:
    def threeEqualParts(self, arr: List[int]) -> List[int]:
        
        n = len(arr)
        ones = sum(arr)
        if ones % 3 != 0:
            return [-1, -1]
        if ones == 0:
            return [0, n - 1]
        ones //= 3
        i = 0
        while ones > 0:
            i += 1
            if arr[i] == 1:
                ones -= 1
        j = i + 1
        while arr[j] == 0:
            j += 1
        k = j
        while arr[k] == 0:
            k += 1
        while k < n:
            if arr[i] != arr[k] or arr[j] != arr[k]:
                return [-1, -1]
            i += 1
            j += 1
            k += 1
        return [i - 1, j]
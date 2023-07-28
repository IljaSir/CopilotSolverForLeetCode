class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        
        arr_len = len(arr)
        if arr_len < 3:
            return -1
        if arr_len == 3:
            return 1
        if arr[0] > arr[1]:
            return -1
        if arr[arr_len - 1] > arr[arr_len - 2]:
            return -1
        left = 0
        right = arr_len - 1
        while left <= right:
            mid = (left + right) // 2
            if arr[mid - 1] < arr[mid] and arr[mid] > arr[mid + 1]:
                return mid
            if arr[mid - 1] < arr[mid] and arr[mid] < arr[mid + 1]:
                left = mid + 1
            else:
                right = mid - 1
        return -1
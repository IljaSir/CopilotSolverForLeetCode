class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        # use binary search to find the closest element
        # then use two pointers to expand
        def binarySearch(arr, x):
            l, r = 0, len(arr)-1
            while l <= r:
                mid = (l+r)//2
                if arr[mid] == x:
                    return mid
                elif arr[mid] > x:
                    r = mid - 1
                else:
                    l = mid + 1
            if l == len(arr):
                return l-1
            if r == -1:
                return 0
            if x-arr[r] <= arr[l]-x:
                return r
            return l
        idx = binarySearch(arr, x)
        l, r = idx, idx
        while r-l+1 < k:
            if l == 0:
                r += 1
            elif r == len(arr)-1:
                l -= 1
            else:
                if x-arr[l-1] <= arr[r+1]-x:
                    l -= 1
                else:
                    r += 1
        return arr[l:r+1]
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        # find the index of the closest element to x
        # then use two pointers to find the k closest elements
        # O(logn+k)
        # O(k)
        # binary search
        l = 0
        r = len(arr)-1
        while l <= r:
            mid = (l+r)//2
            if arr[mid] == x:
                break
            elif arr[mid] > x:
                r = mid - 1
            else:
                l = mid + 1
        # now arr[mid] is the closest element to x
        # then use two pointers
        res = []
        l = mid-1
        r = mid+1
        res.append(arr[mid])
        while len(res) < k:
            if l < 0:
                res.append(arr[r])
                r += 1
            elif r >= len(arr):
                res.insert(0, arr[l])
                l -= 1
            elif abs(arr[l]-x) <= abs(arr[r]-x):
                res.insert(0, arr[l])
                l -= 1
            else:
                res.append(arr[r])
                r += 1
        return res
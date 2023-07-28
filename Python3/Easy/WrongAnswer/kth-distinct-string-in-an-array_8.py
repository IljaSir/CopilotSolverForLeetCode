class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        
        if len(arr) == 1:
            return arr[0]
        arr = list(set(arr))
        arr.sort()
        if k > len(arr):
            return ""
        return arr[k-1]
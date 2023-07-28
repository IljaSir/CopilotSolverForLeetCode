class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        
        s = set()
        for i in range(len(arr)):
            if arr[i] not in s:
                k -= 1
                s.add(arr[i])
                if k == 0:
                    return arr[i]
        return ""
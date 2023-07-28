class Solution:
    def getStrongest(self, arr: List[int], k: int) -> List[int]:
        
        arr.sort()
        n = len(arr)
        median = arr[(n-1)//2]
        return sorted(arr, key=lambda x: (abs(x-median), -x))[-k:]
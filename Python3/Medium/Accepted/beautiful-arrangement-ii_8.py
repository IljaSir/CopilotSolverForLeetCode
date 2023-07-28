class Solution:
    def constructArray(self, n: int, k: int) -> List[int]:
        
        arr = [i for i in range(1, n+1)]
        for i in range(1, k):
            arr[i:] = arr[:i-1:-1]
        return arr
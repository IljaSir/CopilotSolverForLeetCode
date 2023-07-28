class Solution:
    def containsPattern(self, arr: List[int], m: int, k: int) -> bool:
        
        for i in range(len(arr)-m*k+1):
            if all(arr[i+j*m] == arr[i] for j in range(k)):
                return True
        return False
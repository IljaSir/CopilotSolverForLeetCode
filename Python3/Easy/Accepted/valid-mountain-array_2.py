class Solution:
    def validMountainArray(self, arr: List[int]) -> bool:
        
        
        # 1. Find the peak
        # 2. Check if the peak is the first or last element
        # 3. Check if the peak is the only element
        # 4. Check if the peak is the first or last element
        # 5. Check if the elements before the peak are in increasing order
        # 6. Check if the elements after the peak are in decreasing order
        # 7. Return True if all conditions are met, else return False
        
        # 1. Find the peak
        peak = max(arr)
        
        # 2. Check if the peak is the first or last element
        if arr[0] == peak or arr[-1] == peak:
            return False
        
        # 3. Check if the peak is the only element
        if len(arr) == 1:
            return False
        
        # 4. Check if the peak is the first or last element
        if arr[0] == peak or arr[-1] == peak:
            return False
        
        # 5. Check if the elements before the peak are in increasing order
        for i in range(len(arr)):
            if arr[i] == peak:
                break
            if arr[i] >= arr[i+1]:
                return False
        
        # 6. Check if the elements after the peak are in decreasing order
        for i in range(len(arr)-1, -1, -1):
            if arr[i] == peak:
                break
            if arr[i] >= arr[i-1]:
                return False
        
        # 7. Return True if all conditions are met, else return False
        return True
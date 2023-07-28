class Solution:
    def canFormArray(self, arr: List[int], pieces: List[List[int]]) -> bool:
        
        # Iterate through pieces and check if each piece is in arr
        # If a piece is not in arr, return False
        # If all pieces are in arr, return True
        for piece in pieces:
            if piece not in arr:
                return False
        return True
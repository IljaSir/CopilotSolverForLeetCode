class Solution:
    def canBeIncreasing(self, nums: List[int]) -> bool:
        
        # This is a two-pointer problem.
        # The idea is to keep a pointer at the beginning of the array, and another pointer at the end of the array.
        # If the two pointers are the same, then we increment the first pointer.
        # If the two pointers are
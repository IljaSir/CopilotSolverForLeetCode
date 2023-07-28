class Solution:
    def sumOddLengthSubarrays(self, arr: List[int]) -> int:
        
        return sum(arr[i:i+length] for length in range(1, len(arr)+1, 2) for i in range(len(arr)-length+1))
class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        
        return len(set(arr[i] for i in range(len(arr)) if i == max(arr[:i+1])))
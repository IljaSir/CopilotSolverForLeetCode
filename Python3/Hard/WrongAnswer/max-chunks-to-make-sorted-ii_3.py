class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        
        max_seen = 0
        ans = 0
        for i, x in enumerate(arr):
            max_seen = max(max_seen, x)
            if max_seen == i:
                ans += 1
        return ans
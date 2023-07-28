class Solution:
    def largeGroupPositions(self, s: str) -> List[List[int]]:
        
        """O(N) / O(N)"""
        if len(s) < 3: return []
        ans = []
        i, j = 0, 0
        while j < len(s):
            if s[i] != s[j]:
                if j - i >= 3:
                    ans.append([i, j - 1])
                i = j
            j += 1
        if j - i >= 3:
            ans.append([i, j - 1])
        return ans
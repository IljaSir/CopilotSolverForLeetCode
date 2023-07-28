class Solution:
    def maxDepth(self, s: str) -> int:
        
        count = 0
        maxcount = 0
        for i in s:
            if i == '(':
                count += 1
            elif i == ')':
                count -= 1
            maxcount = max(count, maxcount)
        return maxcount
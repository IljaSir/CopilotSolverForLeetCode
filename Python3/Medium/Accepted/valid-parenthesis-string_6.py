class Solution:
    def checkValidString(self, s: str) -> bool:
        
        # greedy
        min_count = 0
        max_count = 0
        for c in s:
            if c == '(':
                min_count += 1
                max_count += 1
            elif c == ')':
                min_count = max(0, min_count - 1)
                max_count -= 1
            else:
                min_count = max(0, min_count - 1)
                max_count += 1
            if max_count < 0:
                return False
        return min_count == 0
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        def isValid(s):
            cnt = 0
            for ch in s:
                if ch == '(':
                    cnt += 1
                elif ch == ')':
                    cnt -= 1
                if cnt < 0:
                    return False
            return cnt == 0
        
        level = {s}
        while True:
            valid = list(filter(isValid, level))
            if valid:
                return valid
            level = {s[:i] + s[i+1:] for s in level for i in range(len(s))}
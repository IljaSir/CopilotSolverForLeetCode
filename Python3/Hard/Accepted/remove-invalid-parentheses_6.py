class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        def isValid(s):
            count = 0
            for c in s:
                if c == '(':
                    count += 1
                elif c == ')':
                    count -= 1
                if count < 0: return False
            return count == 0
        ans = []
        queue = {s}
        found = False
        while queue:
            for s in queue:
                if isValid(s):
                    ans.append(s)
                    found = True
            if found: break
            queue = {s[:i] + s[i+1:] for s in queue for i in range(len(s))}
        return ans
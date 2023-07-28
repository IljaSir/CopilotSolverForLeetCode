class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        def isValid(s):
            count = 0
            for c in s:
                if c == "(":
                    count += 1
                elif c == ")":
                    count -= 1
                if count < 0:
                    return False
            return count == 0
        
        def helper(s, i, l, r, res):
            if l == r == 0 and isValid(s):
                res.append(s)
                return
            for j in range(i, len(s)):
                if j > i and s[j] == s[j - 1]:
                    continue
                if s[j] == "(" and l > 0:
                    helper(s[:j] + s[j + 1:], j, l - 1, r, res)
                if s[j] == ")" and r > 0:
                    helper(s[:j] + s[j + 1:], j, l, r - 1, res)
        
        l, r = 0, 0
        for c in s:
            if c == "(":
                l += 1
            elif c == ")":
                if l == 0:
                    r += 1
                else:
                    l -= 1
        res = []
        helper(s, 0, l, r, res)
        return res
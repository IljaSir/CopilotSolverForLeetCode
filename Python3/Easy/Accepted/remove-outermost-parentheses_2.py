class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        
        result = ""
        count = 0
        for c in s:
            if c == "(":
                count += 1
                if count > 1:
                    result += "("
            elif c == ")":
                count -= 1
                if count > 0:
                    result += ")"
        return result
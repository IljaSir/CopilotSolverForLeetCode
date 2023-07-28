class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        
        # Runtime: 28 ms, faster than 88.23% of Python3 online submissions for Remove Outermost Parentheses.
        # Memory Usage: 14.2 MB, less than 70.09% of Python3 online submissions for Remove Outermost Parentheses.
        stack = []
        res = ''
        for i in s:
            if i == '(':
                if stack:
                    res += i
                stack.append(i)
            else:
                stack.pop()
                if stack:
                    res += i
        return res
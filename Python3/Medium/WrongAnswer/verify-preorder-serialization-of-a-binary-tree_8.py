class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        
        preorder = preorder.split(',')
        stack = []
        for i, c in enumerate(preorder):
            if i == 0:
                stack.append(c)
            else:
                if c == '#' and stack[-1] == '#':
                    stack.pop()
                    if not stack:
                        return False
                    stack[-1] = '#'
                else:
                    stack.append(c)
        return stack == ['#']
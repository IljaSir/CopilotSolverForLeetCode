class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        
        preorder = preorder.split(',')
        stack = []
        for i in preorder:
            if i != '#':
                stack.append(i)
            else:
                while stack and stack[-1] == '#':
                    stack.pop()
                    if not stack:
                        return False
                    stack.pop()
                stack.append('#')
        return stack == ['#']
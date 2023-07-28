class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        
        stack = []
        for c in preorder.split(','):
            stack.append(c)
            while len(stack) > 2 and stack[-1] == stack[-2] == '#' and stack[-3] != '#':
                stack.pop()
                stack.pop()
                stack.pop()
                stack.append('#')
        return stack == ['#']
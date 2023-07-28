class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        
        stack = []
        for i in preorder.split(','):
            stack.append(i)
            while len(stack) >= 3 and stack[-1] == stack[-2] == '#' and stack[-3] != '#':
                stack.pop()
                stack.pop()
                stack.pop()
                stack.append('#')
        return stack == ['#']
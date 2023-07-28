class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        
        preorder = preorder.split(',')
        stack = []
        for i in preorder:
            stack.append(i)
            while len(stack) >= 3 and stack[-1] == '#' and stack[-2] == '#' and stack[-3] != '#':
                stack.pop()
                stack.pop()
                stack.pop()
                stack.append('#')
        return len(stack) == 1 and stack[0] == '#'
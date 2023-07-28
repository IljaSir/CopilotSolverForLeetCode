class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        
        preorder = preorder.split(',')
        stack = []
        for i in preorder:
            if len(stack) == 0:
                stack.append(i)
            else:
                if i == '#':
                    if stack[-1] == '#':
                        while len(stack) >= 2 and stack[-1] == '#':
                            stack.pop()
                            stack.pop()
                        if len(stack) == 0:
                            return False
                        else:
                            stack.append('#')
                    else:
                        stack.append(i)
                else:
                    stack.append(i)
        return len(stack) == 1 and stack[0] == '#'
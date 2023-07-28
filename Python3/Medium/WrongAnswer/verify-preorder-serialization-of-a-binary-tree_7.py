class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        
        preorder = preorder.split(",")
        stack = []
        for i in preorder:
            if i != "#":
                stack.append(i)
            else:
                if stack and stack[-1] == "#":
                    stack.pop()
                    if not stack:
                        return False
                    stack.pop()
                stack.append(i)
        return len(stack) == 1 and stack[0] == "#"
class Solution:
    def removeStars(self, s: str) -> str:
        
        # 1. Create a stack
        # 2. Iterate over the string
        # 3. If the character is not a star, append to the stack
        # 4. If the character is a star, pop from the stack
        # 5. Return the stack as a string
        stack = []
        for char in s:
            if char != '*':
                stack.append(char)
            else:
                if stack:
                    stack.pop()
        return ''.join(stack)
class Solution:
    def decodeString(self, s: str) -> str:
        
        stack = []
        for c in s:
            if c == ']':
                temp = ''
                while stack[-1] != '[':
                    temp = stack.pop() + temp
                stack.pop()
                num = ''
                while stack and stack[-1] in '0123456789':
                    num = stack.pop() + num
                stack.append(temp * int(num))
            else:
                stack.append(c)
        return ''.join(stack)
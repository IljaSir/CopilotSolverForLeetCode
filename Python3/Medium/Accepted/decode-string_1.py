class Solution:
    def decodeString(self, s: str) -> str:
        
        stack = []
        for c in s:
            if c != ']':
                stack.append(c)
            else:
                temp = ''
                while stack[-1] != '[':
                    temp = stack.pop() + temp
                stack.pop()
                num = ''
                while stack and stack[-1].isdigit():
                    num = stack.pop() + num
                stack.append(temp * int(num))
        return ''.join(stack)
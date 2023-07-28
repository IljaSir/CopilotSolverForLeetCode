class Solution:
    def decodeString(self, s: str) -> str:
        
        stack = []
        for c in s:
            if c == ']':
                tmp = []
                while stack and stack[-1] != '[':
                    tmp.append(stack.pop())
                stack.pop()
                num = ''
                while stack and stack[-1].isdigit():
                    num = stack.pop() + num
                stack.append(''.join(tmp[::-1]) * int(num))
            else:
                stack.append(c)
        return ''.join(stack)
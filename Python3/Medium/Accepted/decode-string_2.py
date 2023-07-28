class Solution:
    def decodeString(self, s: str) -> str:
        
        stack = []
        for c in s:
            if c != ']':
                stack.append(c)
            else:
                string = ''
                while stack[-1] != '[':
                    string = stack.pop() + string
                stack.pop()
                num = ''
                while stack and stack[-1].isdigit():
                    num = stack.pop() + num
                stack.append(string * int(num))
        return ''.join(stack)
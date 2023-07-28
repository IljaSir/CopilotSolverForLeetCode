class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        stack = []
        for d in num:
            while k and stack and stack[-1] > d:
                stack.pop()
                k -= 1
            stack.append(d)
        return ''.join(stack[:-k or None]).lstrip('0') or '0'
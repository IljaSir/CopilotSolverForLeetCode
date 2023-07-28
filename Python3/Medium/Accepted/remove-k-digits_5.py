class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        stack = []
        for n in num:
            while stack and stack[-1] > n and k > 0:
                stack.pop()
                k -= 1
            stack.append(n)
        if k > 0:
            stack = stack[:-k]
        return ''.join(stack).lstrip('0') or '0'
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        stack = []
        for i in num:
            while k and stack and stack[-1] > i:
                stack.pop()
                k -= 1
            stack.append(i)
        while k:
            stack.pop()
            k -= 1
        return "".join(stack).lstrip("0") or "0"
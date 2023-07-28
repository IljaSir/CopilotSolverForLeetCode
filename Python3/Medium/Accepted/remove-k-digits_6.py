class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        if len(num) == k:
            return "0"
        stack = []
        for digit in num:
            while stack and k and stack[-1] > digit:
                stack.pop()
                k -= 1
            stack.append(digit)
        while k:
            stack.pop()
            k -= 1
        return "".join(stack).lstrip("0") or "0"
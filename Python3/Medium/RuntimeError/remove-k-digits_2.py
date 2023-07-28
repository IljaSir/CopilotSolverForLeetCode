class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        stack = []
        for n in num:
            while k > 0 and stack and stack[-1] > n:
                stack.pop()
                k -= 1
            stack.append(n)
        while k > 0:
            stack.pop()
            k -= 1
        return str(int(''.join(stack)))
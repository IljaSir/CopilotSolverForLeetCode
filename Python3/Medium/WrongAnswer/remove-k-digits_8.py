class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        if k >= len(num):
            return "0"
        stack = []
        for n in num:
            while stack and k and int(stack[-1]) > int(n):
                stack.pop()
                k -= 1
            stack.append(n)
        return str(int("".join(stack[:len(num)-k])))
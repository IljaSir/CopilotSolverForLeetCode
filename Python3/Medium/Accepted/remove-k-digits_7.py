class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        if len(num) == k:
            return "0"
        stack = []
        for i in range(len(num)):
            while stack and num[i] < stack[-1] and k > 0:
                stack.pop()
                k -= 1
            stack.append(num[i])
        while k > 0:
            stack.pop()
            k -= 1
        return str(int("".join(stack)))
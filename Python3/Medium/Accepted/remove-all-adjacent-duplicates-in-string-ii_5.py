class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        
        stack = []
        for ch in s:
            if not stack or stack[-1][0] != ch:
                stack.append([ch, 1])
            else:
                stack[-1][1] += 1
                if stack[-1][1] == k:
                    stack.pop()
        return "".join(ch * k for ch, k in stack)
class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        
        stack = []
        for i in range(len(s)):
            if s[i] in stack:
                continue
            while stack and stack[-1] > s[i] and s[i] in s[i+1:]:
                stack.pop()
            stack.append(s[i])
        return "".join(stack)
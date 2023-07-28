class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        
        from collections import Counter
        counter = Counter(s)
        stack = []
        for i in s:
            if i in stack:
                counter[i] -= 1
                continue
            while stack and stack[-1] > i and counter[stack[-1]] > 0:
                stack.pop()
            stack.append(i)
            counter[i] -= 1
        return ''.join(stack)
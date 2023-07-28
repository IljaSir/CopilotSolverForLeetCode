class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        
        if x < y:
            x, y = y, x
            s = s.replace('a', 'A').replace('b', 'B').replace('A', 'b').replace('B', 'a')
        s = s.replace('a', 'A').replace('b', 'B').replace('A', 'a').replace('B', 'b')
        stack = []
        for c in s:
            if c == 'b':
                if len(stack) > 0 and stack[-1] == 'a':
                    stack.pop()
                    continue
            stack.append(c)
        return len(stack) * x
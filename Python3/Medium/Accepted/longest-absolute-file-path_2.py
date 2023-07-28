class Solution:
    def lengthLongestPath(self, input: str) -> int:
        
        stack = [(-1,0)]
        res = 0
        for line in input.splitlines():
            name = line.lstrip('\t')
            depth = len(line) - len(name)
            while stack[-1][0] >= depth:
                stack.pop()
            if '.' in name:
                res = max(res, stack[-1][1] + len(name))
            else:
                stack.append((depth, stack[-1][1] + len(name) + 1))
        return res
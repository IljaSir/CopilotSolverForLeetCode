class Solution:
    def lengthLongestPath(self, input: str) -> int:
        
        stack = []
        max_len = 0
        for line in input.splitlines():
            level = line.count('\t')
            while len(stack) > level:
                stack.pop()
            stack.append(len(line) - level + 1)
            if '.' in line:
                max_len = max(max_len, sum(stack))
        return max_len
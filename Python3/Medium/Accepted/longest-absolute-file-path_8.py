class Solution:
    def lengthLongestPath(self, input: str) -> int:
        
        max_len = 0
        stack = []
        for path in input.splitlines():
            depth = path.count('\t')
            while len(stack) > depth:
                stack.pop()
            stack.append(len(path) - depth)
            if '.' in path:
                max_len = max(max_len, sum(stack) + len(stack) - 1)
        return max_len
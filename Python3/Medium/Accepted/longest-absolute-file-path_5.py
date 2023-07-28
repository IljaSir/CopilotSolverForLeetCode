class Solution:
    def lengthLongestPath(self, input: str) -> int:
        
        max_len = 0
        stack = []
        for line in input.split('\n'):
            name = line.lstrip('\t')
            depth = len(line) - len(name)
            while len(stack) > depth:
                stack.pop()
            stack.append(len(name))
            if '.' in name:
                max_len = max(max_len, sum(stack) + len(stack) - 1)
        return max_len
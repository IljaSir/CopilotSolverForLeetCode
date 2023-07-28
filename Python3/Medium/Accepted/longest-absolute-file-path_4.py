class Solution:
    def lengthLongestPath(self, input: str) -> int:
        
        stack = []
        longest = 0
        for line in input.split('\n'):
            name = line.lstrip('\t')
            depth = len(line) - len(name)
            while len(stack) > depth:
                stack.pop()
            stack.append(len(name))
            if '.' in name:
                longest = max(longest, sum(stack) + len(stack) - 1)
        return longest
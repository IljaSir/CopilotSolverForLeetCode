class Solution:
    def lengthLongestPath(self, input: str) -> int:
        
        stack = []
        max_len = 0
        for line in input.splitlines():
            name = line.lstrip('\t')
            depth = len(line) - len(name)
            while stack and stack[-1][1] >= depth:
                stack.pop()
            if '.' in name:
                max_len = max(max_len, len('/'.join([p[0] for p in stack]) + '/' + name))
            else:
                stack.append((name, depth))
        return max_len
class Solution:
    def lengthLongestPath(self, input: str) -> int:
        
        stack = []
        max_len = 0
        for line in input.splitlines():
            level = line.count('\t')
            name = line.replace('\t', '')
            while len(stack) > level:
                stack.pop()
            if '.' in name:
                max_len = max(max_len, len('/'.join(stack)) + len(name))
            else:
                stack.append(name)
        return max_len
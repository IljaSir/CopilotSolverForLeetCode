class Solution:
    def simplifyPath(self, path: str) -> str:
        
        stack = []
        for p in path.split('/'):
            if p == '..' and stack:
                stack.pop()
            elif p not in ('..', '.', ''):
                stack.append(p)
        return '/' + '/'.join(stack)
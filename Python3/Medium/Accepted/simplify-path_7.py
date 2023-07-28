class Solution:
    def simplifyPath(self, path: str) -> str:
        
        p = path.split('/')
        p = [x for x in p if x not in ['', '.']]
        stack = []
        for i in p:
            if i == '..':
                if stack:
                    stack.pop()
            else:
                stack.append(i)
        return '/' + '/'.join(stack)
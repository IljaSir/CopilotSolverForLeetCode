class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        def is_valid(s):
            cnt = 0
            for c in s:
                if c == '(':
                    cnt += 1
                elif c == ')':
                    cnt -= 1
                    if cnt < 0:
                        return False
            return cnt == 0
        
        def dfs(s, index, left, right, ans):
            if left == 0 and right == 0:
                if is_valid(s):
                    ans.add(s)
                return
            for i in range(index, len(s)):
                if i != index and s[i] == s[i-1]:
                    continue
                if s[i] == '(' and left > 0:
                    dfs(s[:i] + s[i+1:], i, left - 1, right, ans)
                elif s[i] == ')' and right > 0:
                    dfs(s[:i] + s[i+1:], i, left, right - 1, ans)
        
        left = right = 0
        for c in s:
            if c == '(':
                left += 1
            elif c == ')':
                if left > 0:
                    left -= 1
                else:
                    right += 1
        ans = set()
        dfs(s, 0, left, right, ans)
        return list(ans)
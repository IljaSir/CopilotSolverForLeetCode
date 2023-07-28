class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        def is_palindrome(s):
            return s == s[::-1]
        
        def dfs(i, path):
            if i == len(s):
                res.append(path)
                return
            for j in range(i, len(s)):
                if is_palindrome(s[i:j+1]):
                    dfs(j+1, path+[s[i:j+1]])
        
        res = []
        dfs(0, [])
        return res
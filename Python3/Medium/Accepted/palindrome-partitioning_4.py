class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        def is_palindrome(s):
            return s == s[::-1]
        
        def backtrack(s, path):
            if not s:
                res.append(path)
                return
            for i in range(1, len(s) + 1):
                if is_palindrome(s[:i]):
                    backtrack(s[i:], path + [s[:i]])
        
        res = []
        backtrack(s, [])
        return res
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        def is_palindrome(s):
            return s == s[::-1]
        def backtrack(start, path):
            if start == len(s):
                res.append(path[:])
                return
            for end in range(start + 1, len(s) + 1):
                if is_palindrome(s[start:end]):
                    path.append(s[start:end])
                    backtrack(end, path)
                    path.pop()
        res = []
        backtrack(0, [])
        return res
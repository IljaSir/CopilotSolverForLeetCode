class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        def isPalindrome(string):
            return string == string[::-1]
        
        def backtrack(index, path):
            if index == len(s):
                res.append(path)
                return
            for i in range(index, len(s)):
                if isPalindrome(s[index:i+1]):
                    backtrack(i+1, path+[s[index:i+1]])
        
        res = []
        backtrack(0, [])
        return res
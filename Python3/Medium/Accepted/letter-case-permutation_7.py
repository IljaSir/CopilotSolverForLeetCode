class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        
        result = []
        def dfs(s, index):
            if index == len(s):
                result.append(s)
                return
            if s[index].isalpha():
                dfs(s[:index] + s[index].upper() + s[index+1:], index+1)
                dfs(s[:index] + s[index].lower() + s[index+1:], index+1)
            else:
                dfs(s, index+1)
        dfs(s, 0)
        return result
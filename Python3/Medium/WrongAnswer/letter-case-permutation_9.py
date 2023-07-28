class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        
        ans = []
        for i in range(2**len(s)):
            ans.append(''.join([s[j].upper() if (i>>j)&1 else s[j].lower() for j in range(len(s))]))
        return ans
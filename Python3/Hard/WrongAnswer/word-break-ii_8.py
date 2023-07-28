class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        
        def dfs(s, wordDict, mem):
            if s in mem:
                return mem[s]
            if s in wordDict:
                mem[s] = [s]
                return mem[s]
            for i in range(1, len(s)):
                left, right = s[:i], s[i:]
                if right in wordDict:
                    for left in dfs(left, wordDict, mem):
                        mem[s] = mem.get(s, []) + [left + ' ' + right]
            return mem.get(s, [])
        
        mem = {}
        return dfs(s, set(wordDict), mem)
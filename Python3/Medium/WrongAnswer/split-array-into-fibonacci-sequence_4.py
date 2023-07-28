class Solution:
    def splitIntoFibonacci(self, num: str) -> List[int]:
        
        def dfs(s, path):
            if not s and len(path) >= 3:
                return path
            for i in range(1, len(s)+1):
                if s[:i].lstrip('0') != s[:i]:
                    continue
                if len(path) >= 2 and int(s[:i]) > path[-1] + path[-2]:
                    break
                if len(path) <= 1 or int(s[:i]) == path[-1] + path[-2]:
                    if dfs(s[i:], path + [int(s[:i])]):
                        return path + [int(s[:i])]
        return dfs(num, [])
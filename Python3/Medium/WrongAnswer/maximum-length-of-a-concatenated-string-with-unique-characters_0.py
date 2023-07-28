class Solution:
    def maxLength(self, arr: List[str]) -> int:
        
        
        def dfs(idx, cur):
            nonlocal ans
            ans = max(ans, len(cur))
            for i in range(idx, len(arr)):
                if len(set(arr[i]) & set(cur)) == 0:
                    dfs(i+1, cur+arr[i])
        
        ans = 0
        dfs(0, '')
        return ans
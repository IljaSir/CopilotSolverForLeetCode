class Solution:
    def distributeCookies(self, cookies: List[int], k: int) -> int:
        
        cookies.sort()
        n = len(cookies)
        result = float('inf')
        for i in range(n - k + 1):
            result = min(result, cookies[i + k - 1] - cookies[i])
        return result
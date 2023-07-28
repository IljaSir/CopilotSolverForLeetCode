class Solution:
    def countAndSay(self, n: int) -> str:
        
        prev = '1'
        for _ in range(n-1):
            prev = self.next(prev)
        return prev
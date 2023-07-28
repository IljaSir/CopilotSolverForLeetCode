class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        
        # Time  complexity: O(N)
        # Space complexity: O(1)
        ans = 0
        for i in range(1, n + 1):
            ans = (ans + k) % i
        return ans + 1
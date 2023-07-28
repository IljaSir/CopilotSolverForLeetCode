class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        
        def get_next(current):
            return (current + k - 1) % n + 1
        current = 1
        for i in range(n - 1):
            current = get_next(current)
        return current
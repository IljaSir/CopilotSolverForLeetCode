class Solution:
    def divisorGame(self, n: int) -> bool:
        
        # 1. If n is even, then Alice wins.
        # 2. If n is odd, then Alice loses.
        return n % 2 == 0
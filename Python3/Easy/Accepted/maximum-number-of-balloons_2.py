class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        
        # Solution 1 - 28 ms
        """
        return min(text.count('b'), text.count('a'), text.count('l') // 2, text.count('o') // 2, text.count('n'))
        """
        # Solution 2 - 24 ms
        from collections import Counter
        return min(Counter(text)[c] // v for c, v in Counter('balloon').items())
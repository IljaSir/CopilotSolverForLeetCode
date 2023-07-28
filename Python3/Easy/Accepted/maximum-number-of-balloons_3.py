class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        
        count = collections.Counter(text)
        return min(count[c] // 'balloon'.count(c) for c in 'balloon')
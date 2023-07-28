class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        
        
        n = len(cardPoints)
        if k>=n:
            return sum(cardPoints)
        else:
            return max(sum(cardPoints[i:i+k]) for i in range(n-k+1))
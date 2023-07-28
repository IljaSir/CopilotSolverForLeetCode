class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        
        
        if k == 1:
            return max(cardPoints[0], cardPoints[-1])
        
        if k == len(cardPoints):
            return sum(cardPoints)
        
        if k == len(cardPoints) - 1:
            return max(sum(cardPoints[1:]), sum(cardPoints[:-1]))
        
        if k == len(cardPoints) - 2:
            return max(cardPoints[0] + cardPoints[-1] + cardPoints[-2], cardPoints[0] + cardPoints[1] + cardPoints[-1])
        
        if k == len(cardPoints) - 3:
            return max(cardPoints[0] + cardPoints[1] + cardPoints[2] + cardPoints[-1], cardPoints[0] + cardPoints[-1] + cardPoints[-2] + cardPoints[-3])
        
        if k == len(cardPoints) - 4:
            return max(cardPoints[0] + cardPoints[1] + cardPoints[2] + cardPoints[3] + cardPoints[-1], cardPoints[0] + cardPoints[-1] + cardPoints[-2] + cardPoints[-3] + cardPoints[-4])
        
        if k == len(cardPoints) - 5:
            return max(cardPoints[0] + cardPoints[1] + cardPoints[2] + cardPoints[3] + cardPoints[4] + cardPoints[-1], cardPoints[0] + cardPoints[-1] + cardPoints[-2] + cardPoints[-3] + cardPoints[-4] + cardPoints[-5])
        
        if k == len(cardPoints) - 6:
            return max(cardPoints[0] + cardPoints[1] + cardPoints[2] + cardPoints[3] + cardPoints[4] + cardPoints[5] + cardPoints[-1], cardPoints[0] + cardPoints[-1] + cardPoints[-2] + cardPoints[-3] + cardPoints[-4] + cardPoints[-5] + cardPoints[-6])
        
        if k == len(cardPoints) - 7:
            return max(cardPoints[0] + cardPoints[1] + cardPoints[2] + cardPoints[3] + cardPoints[4] + cardPoints[5] + cardPoints[6] + cardPoints[-1], card
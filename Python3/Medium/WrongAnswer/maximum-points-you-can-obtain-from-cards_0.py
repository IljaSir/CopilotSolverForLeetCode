class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        
        if len(cardPoints) == 1:
            return cardPoints[0]
        if k == 1:
            return max(cardPoints[0], cardPoints[-1])
        if k == len(cardPoints):
            return sum(cardPoints)
        if k == 2:
            return max(cardPoints[0] + cardPoints[-1], cardPoints[1] + cardPoints[-2], cardPoints[0] + cardPoints[1], cardPoints[-1] + cardPoints[-2])
        if k == 3:
            return max(cardPoints[0] + cardPoints[-1] + cardPoints[-2], cardPoints[0] + cardPoints[1] + cardPoints[-1], cardPoints[0] + cardPoints[1] + cardPoints[2], cardPoints[-1] + cardPoints[-2] + cardPoints[-3])
        return max(sum(cardPoints[:k]), sum(cardPoints[-k:]), sum(cardPoints[:k-1]) + cardPoints[-1], sum(cardPoints[:k-2]) + cardPoints[-1] + cardPoints[-2], sum(cardPoints[:k-3]) + cardPoints[-1] + cardPoints[-2] + cardPoints[-3], cardPoints[0] + sum(cardPoints[-k+1:]), cardPoints[0] + cardPoints[1] + sum(cardPoints[-k+2:]))
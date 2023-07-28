class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        
        rank = ["Gold Medal", "Silver Medal", "Bronze Medal"]
        score = sorted(score, reverse=True)
        return [rank[i] if i < 3 else str(i+1) for i in range(len(score))]
class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        
        sorted_score = sorted(score, reverse=True)
        rank = {}
        for i, v in enumerate(sorted_score):
            if i == 0:
                rank[v] = "Gold Medal"
            elif i == 1:
                rank[v] = "Silver Medal"
            elif i == 2:
                rank[v] = "Bronze Medal"
            else:
                rank[v] = str(i + 1)
        return [rank[v] for v in score]
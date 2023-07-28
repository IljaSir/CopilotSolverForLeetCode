class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        
        rank = [0] * len(score)
        for i, v in enumerate(sorted(score, reverse=True)):
            rank[score.index(v)] = i + 1
        for i, v in enumerate(rank):
            if v == 1:
                rank[i] = "Gold Medal"
            elif v == 2:
                rank[i] = "Silver Medal"
            elif v == 3:
                rank[i] = "Bronze Medal"
            else:
                rank[i] = str(v)
        return rank
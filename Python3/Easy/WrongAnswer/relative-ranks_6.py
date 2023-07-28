class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        
        sorted_score = sorted(score, reverse=True)
        medal = ["Gold Medal", "Silver Medal", "Bronze Medal"]
        result = []
        for i in range(len(score)):
            if i < 3:
                result.append(medal[i])
            else:
                result.append(str(i + 1))
        for i in range(len(score)):
            result[i] = result[sorted_score.index(score[i])]
        return result
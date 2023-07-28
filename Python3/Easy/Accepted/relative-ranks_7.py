class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        
        sorted_score = sorted(score, reverse=True)
        medals = ["Gold Medal", "Silver Medal", "Bronze Medal"]
        result = []
        for s in score:
            index = sorted_score.index(s)
            if index < 3:
                result.append(medals[index])
            else:
                result.append(str(index + 1))
        return result
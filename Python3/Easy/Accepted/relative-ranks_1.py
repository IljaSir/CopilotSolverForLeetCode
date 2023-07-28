class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        
        sorted_score = sorted(score, reverse=True)
        result = []
        for i in score:
            if i == sorted_score[0]:
                result.append('Gold Medal')
            elif i == sorted_score[1]:
                result.append('Silver Medal')
            elif i == sorted_score[2]:
                result.append('Bronze Medal')
            else:
                result.append(str(sorted_score.index(i) + 1))
        return result
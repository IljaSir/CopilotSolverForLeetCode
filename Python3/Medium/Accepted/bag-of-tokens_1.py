class Solution:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        
        tokens = sorted(tokens)
        score = 0
        max_score = 0
        i = 0
        j = len(tokens) - 1
        while i <= j:
            if power >= tokens[i]:
                power -= tokens[i]
                score += 1
                i += 1
                max_score = max(max_score, score)
            elif score > 0:
                power += tokens[j]
                score -= 1
                j -= 1
            else:
                break
        return max_score
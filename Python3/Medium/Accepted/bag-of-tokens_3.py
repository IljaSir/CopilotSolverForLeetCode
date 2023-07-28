class Solution:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        
        
        tokens.sort()
        if not tokens:
            return 0
        if len(tokens) == 1:
            if tokens[0] > power:
                return 0
            else:
                return 1

        i = 0
        j = len(tokens)-1
        score = 0
        while i <= j:
            if tokens[i] <= power:
                power -= tokens[i]
                score += 1
                i += 1
            elif score > 0 and i < j:
                power += tokens[j]
                score -= 1
                j -= 1
            else:
                break
        return score
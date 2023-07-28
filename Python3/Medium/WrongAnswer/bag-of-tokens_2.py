class Solution:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        
        tokens.sort()
        ans = 0
        i = 0
        j = len(tokens) - 1
        while i <= j:
            if power >= tokens[i]:
                power -= tokens[i]
                ans += 1
                i += 1
            elif ans > 0:
                power += tokens[j]
                ans -= 1
                j -= 1
            else:
                break
        return ans
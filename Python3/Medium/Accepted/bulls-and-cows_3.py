class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        
        bulls = sum(i == j for i, j in zip(secret, guess))
        both = sum(min(secret.count(x), guess.count(x)) for x in '0123456789')
        return "%sA%sB" % (bulls, both - bulls)
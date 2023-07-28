class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        
        bulls = sum(s == g for s, g in zip(secret, guess))
        both = sum(min(secret.count(x), guess.count(x)) for x in set(secret))
        return "{}A{}B".format(bulls, both - bulls)
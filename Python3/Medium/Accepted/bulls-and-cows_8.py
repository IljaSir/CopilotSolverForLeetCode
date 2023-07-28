class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        
        bulls = sum([int(a==b) for a,b in zip(secret, guess)])
        both = sum(min(secret.count(x), guess.count(x)) for x in '0123456789')
        return "%dA%dB" % (bulls, both-bulls)
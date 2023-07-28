class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        
        bulls = 0
        cows = 0
        secret = list(secret)
        guess = list(guess)
        for i in range(len(secret)):
            if secret[i] == guess[i]:
                bulls += 1
                secret[i] = None
                guess[i] = None
        for i in range(len(secret)):
            if secret[i] is not None and secret[i] in guess:
                cows += 1
                guess[guess.index(secret[i])] = None
        return '{}A{}B'.format(bulls, cows)
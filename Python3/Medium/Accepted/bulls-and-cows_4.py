class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        
        secret = list(secret)
        guess = list(guess)
        bulls = 0
        cows = 0
        for i in range(len(secret)):
            if secret[i] == guess[i]:
                bulls += 1
                secret[i] = guess[i] = 'B'
        for i in range(len(secret)):
            if secret[i] != 'B':
                if secret[i] in guess:
                    cows += 1
                    guess[guess.index(secret[i])] = 'C'
        return str(bulls) + 'A' + str(cows) + 'B'
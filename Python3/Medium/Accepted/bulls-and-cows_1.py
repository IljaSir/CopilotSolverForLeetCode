class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        
        bulls = 0
        cows = 0
        secret = list(secret)
        guess = list(guess)
        for i in range(len(secret)):
            if secret[i] == guess[i]:
                bulls += 1
                secret[i] = guess[i] = 'A'
        for i in range(len(secret)):
            if secret[i] != 'A':
                for j in range(len(guess)):
                    if guess[j] != 'A' and secret[i] == guess[j]:
                        cows += 1
                        guess[j] = 'A'
                        break
        return str(bulls) + 'A' + str(cows) + 'B'
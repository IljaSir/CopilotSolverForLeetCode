class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        
        A = sum([1 for i in range(len(secret)) if secret[i] == guess[i]])
        B = sum([min(secret.count(x), guess.count(x)) for x in set(secret) & set(guess)]) - A
        return f'{A}A{B}B'
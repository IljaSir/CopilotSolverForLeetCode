class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        
        bulls, cows = 0, 0
        secret_list = list(secret)
        guess_list = list(guess)
        for i in range(len(secret_list)):
            if secret_list[i] == guess_list[i]:
                bulls += 1
                secret_list[i] = guess_list[i] = 'B'
        for i in range(len(secret_list)):
            if secret_list[i] == 'B':
                continue
            if secret_list[i] in guess_list:
                cows += 1
                guess_list[guess_list.index(secret_list[i])] = 'C'
        return str(bulls) + 'A' + str(cows) + 'B'
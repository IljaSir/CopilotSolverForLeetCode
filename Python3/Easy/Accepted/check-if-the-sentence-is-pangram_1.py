class Solution:
    def checkIfPangram(self, sentence: str) -> bool:
        
        alphabet = 'abcdefghijklmnopqrstuvwxyz'
        for letter in alphabet:
            if letter not in sentence:
                return False
        return True
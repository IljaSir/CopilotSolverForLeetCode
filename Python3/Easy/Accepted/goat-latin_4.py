class Solution:
    def toGoatLatin(self, sentence: str) -> str:
        
        vowels = 'aeiouAEIOU'
        words = sentence.split()
        for i, word in enumerate(words):
            if word[0] in vowels:
                words[i] = word + 'ma' + 'a' * (i + 1)
            else:
                words[i] = word[1:] + word[0] + 'ma' + 'a' * (i + 1)
        return ' '.join(words)
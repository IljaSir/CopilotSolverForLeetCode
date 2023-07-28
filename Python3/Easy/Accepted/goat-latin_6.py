class Solution:
    def toGoatLatin(self, sentence: str) -> str:
        
        vowels = set('aeiou')
        words = sentence.split()
        for i, word in enumerate(words):
            if word[0].lower() not in vowels:
                word = word[1:] + word[0]
            words[i] = word + 'ma' + 'a' * (i + 1)
        return ' '.join(words)
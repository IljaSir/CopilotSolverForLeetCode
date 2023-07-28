class Solution:
    def toGoatLatin(self, sentence: str) -> str:
        
        vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']
        words = sentence.split()
        for i in range(len(words)):
            if words[i][0] in vowels:
                words[i] += 'ma'
            else:
                words[i] = words[i][1:] + words[i][0] + 'ma'
            words[i] += 'a' * (i+1)
        return ' '.join(words)
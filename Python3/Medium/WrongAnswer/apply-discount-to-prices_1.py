class Solution:
    def discountPrices(self, sentence: str, discount: int) -> str:
        
        # print(sentence, discount)
        words = sentence.split()
        for i in range(len(words)):
            if words[i][0] == '$':
                words[i] = '$' + str(round(float(words[i][1:]) * (1 - discount / 100), 2))
        return ' '.join(words)
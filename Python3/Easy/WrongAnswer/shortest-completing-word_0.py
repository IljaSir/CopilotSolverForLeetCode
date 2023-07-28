class Solution:
    def shortestCompletingWord(self, licensePlate: str, words: List[str]) -> str:
        
        licensePlate = licensePlate.lower()
        licensePlate = licensePlate.replace(' ', '')
        licensePlate = licensePlate.replace('0', '')
        licensePlate = licensePlate.replace('1', '')
        licensePlate = licensePlate.replace('2', '')
        licensePlate = licensePlate.replace('3', '')
        licensePlate = licensePlate.replace('4', '')
        licensePlate = licensePlate.replace('5', '')
        licensePlate = licensePlate.replace('6', '')
        licensePlate = licensePlate.replace('7', '')
        licensePlate = licensePlate.replace('8', '')
        licensePlate = licensePlate.replace('9', '')
        words = sorted(words, key = lambda x: len(x))
        for word in words:
            word = word.lower()
            for i in range(0, len(licensePlate)):
                if licensePlate[i] in word:
                    word = word.replace(licensePlate[i], '', 1)
                else:
                    break
            if len(word) == 0:
                return word
        return words[0]
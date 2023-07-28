class Solution:
    def shortestCompletingWord(self, licensePlate: str, words: List[str]) -> str:
        
        licensePlate = licensePlate.lower()
        licensePlate = licensePlate.replace(" ","")
        licensePlate = licensePlate.replace("0","")
        licensePlate = licensePlate.replace("1","")
        licensePlate = licensePlate.replace("2","")
        licensePlate = licensePlate.replace("3","")
        licensePlate = licensePlate.replace("4","")
        licensePlate = licensePlate.replace("5","")
        licensePlate = licensePlate.replace("6","")
        licensePlate = licensePlate.replace("7","")
        licensePlate = licensePlate.replace("8","")
        licensePlate = licensePlate.replace("9","")
        licensePlate = list(licensePlate)
        words = sorted(words, key = len)
        for word in words:
            word = list(word)
            for letter in licensePlate:
                if letter in word:
                    word.remove(letter)
            if len(word) == 0:
                return "".join(word)
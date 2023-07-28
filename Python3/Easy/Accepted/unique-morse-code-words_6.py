class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        
        morse_code = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        morse_words = set()
        for word in words:
            morse = ""
            for letter in word:
                morse += morse_code[ord(letter) - ord('a')]
            morse_words.add(morse)
        return len(morse_words)
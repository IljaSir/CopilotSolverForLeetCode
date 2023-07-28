class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        
        morse_code = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        morse_words = set()
        for word in words:
            morse_word = ''
            for char in word:
                morse_word += morse_code[ord(char) - 97]
            morse_words.add(morse_word)
        return len(morse_words)
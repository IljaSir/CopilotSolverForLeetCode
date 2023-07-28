class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        
        morse = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        morse_dict = {}
        for i in range(len(morse)):
            morse_dict[chr(i+97)] = morse[i]
        morse_words = []
        for word in words:
            morse_word = ""
            for letter in word:
                morse_word += morse_dict[letter]
            morse_words.append(morse_word)
        return len(set(morse_words))
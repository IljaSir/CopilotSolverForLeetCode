class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        
        morse_code = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        morse_map = {}
        for i in range(26):
            morse_map[chr(ord('a') + i)] = morse_code[i]
        morse_set = set()
        for word in words:
            morse_word = ''
            for letter in word:
                morse_word += morse_map[letter]
            morse_set.add(morse_word)
        return len(morse_set)
class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        
        morse_code = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        morse_dict = {}
        for i in range(0,26):
            morse_dict[chr(i+97)] = morse_code[i]
        morse_set = set()
        for word in words:
            morse_word = ""
            for char in word:
                morse_word += morse_dict[char]
            morse_set.add(morse_word)
        return len(morse_set)
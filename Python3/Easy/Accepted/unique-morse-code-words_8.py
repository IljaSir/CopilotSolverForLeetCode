class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        
        morse_code = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        morse_code_map = dict()
        for i in range(26):
            morse_code_map[chr(i + 97)] = morse_code[i]
        return len(set([''.join([morse_code_map[i] for i in word]) for word in words]))
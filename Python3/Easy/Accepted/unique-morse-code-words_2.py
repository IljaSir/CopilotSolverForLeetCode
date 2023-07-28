class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        
        morse_code = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        morse_code_dict = {chr(i + 97): morse_code[i] for i in range(26)}
        return len({"".join([morse_code_dict[letter] for letter in word]) for word in words})
class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        
        morse = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        seen = set()
        for word in words:
            seen.add("".join(morse[ord(c) - ord('a')] for c in word))
        return len(seen)
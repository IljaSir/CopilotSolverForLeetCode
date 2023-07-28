class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        
        d = {chr(i):morse for i, morse in zip(range(97, 123), [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."])}
        return len(set(''.join(d[i] for i in word) for word in words))
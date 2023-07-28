class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        
        # Sort words by length
        words.sort(key=len)
        # Initialize output list
        output = []
        # Iterate over words
        for i, word in enumerate(words):
            # Iterate over remaining words
            for j in range(i+1, len(words)):
                # Check if word is substring of remaining words
                if word in words[j]:
                    output.append(word)
                    break
        return output
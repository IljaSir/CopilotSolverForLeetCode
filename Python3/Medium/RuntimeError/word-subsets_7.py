class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        
        # 1. Find the max frequency of each character in words2
        # 2. Check if the frequency of each character in words1 is >= the frequency of each character in words2
        # 3. If yes, then add the word to the result
        # 4. Return the result
        max_freq = {}
        for word in words2:
            freq = self.get_freq(word)
            for char in freq:
                if char not in max_freq:
                    max_freq[char] = 0
                max_freq[char] = max(max_freq[char], freq[char])
        result = []
        for word in words1:
            freq = self.get_freq(word)
            for char in max_freq:
                if char not in freq or freq[char] < max_freq[char]:
                    break
            else:
                result.append(word)
        return result
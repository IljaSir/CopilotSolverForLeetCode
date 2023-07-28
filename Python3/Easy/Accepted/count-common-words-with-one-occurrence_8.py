class Solution:
    def countWords(self, words1: List[str], words2: List[str]) -> int:
        
        # Get the count of each word in each list
        # If the count is 1, increment the count of unique words
        # Return the count of unique words
        count = 0
        words1_count = {}
        words2_count = {}
        for word in words1:
            if word in words1_count:
                words1_count[word] += 1
            else:
                words1_count[word] = 1
        for word in words2:
            if word in words2_count:
                words2_count[word] += 1
            else:
                words2_count[word] = 1
        for word in words1_count:
            if word in words2_count and words1_count[word] == 1 and words2_count[word] == 1:
                count += 1
        return count
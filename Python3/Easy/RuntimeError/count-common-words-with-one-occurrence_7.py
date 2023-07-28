class Solution:
    def countWords(self, words1: List[str], words2: List[str]) -> int:
        
        # 1. Count the number of occurrences of each word in each list.
        # 2. Count the number of words that appear exactly once in both lists.
        # 3. Return the count.
        # 4. Time: O(n) where n is the number of words in the two lists.
        # 5. Space: O(n) where n is the number of words in the two lists.
        # 6. Edge cases: No edge cases.
        # 7. Approach: Hash table.
        # 8. Analysis: 
        # 9. Alternative approach: 
        # 10. Alternative analysis: 
        # 11. Alternative code:
        # def countWords(self, words1: List[str], words2: List[str]) -> int:
        #     count = 0
        #     for word in words1:
        #         if word in words2 and words1.count(word) == 1 and words2.count(word) == 1:
        #             count += 1
        #     return count
        # 12. Alternative alternative code:
        # def countWords(self, words1: List[str], words2: List[str]) -> int:
        #     return len(set(words1) & set(words2) - set([word for word in words1 if words1.count(word) > 1]) - set([word for word in words2 if words2.count(word) > 1]))
        # 13. Alternative alternative alternative code:
        # def countWords(self, words1: List[str], words2: List[str]) -> int:
        #     return sum(words1.count(word) == 1 and words2.count(word) == 1 for word in set(words1) & set(words2))
        # 14. Alternative alternative alternative alternative code:
        # def countWords(self, words1: List[str], words2: List[str]) -> int:
        #     return sum(words1.count(word) == words2.count(word) == 1 for word in set(words1) & set(words2))
        # 15. Alternative alternative alternative alternative alternative code:
        # def countWords(self, words1: List[str], words2: List[str]) -> int:
        #     return sum(words1.count(word) == words2.count(word) == 1 for word in set(words1) & set
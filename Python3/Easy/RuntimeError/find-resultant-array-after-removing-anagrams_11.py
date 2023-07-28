class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        
        # This solution is not accepted because of the time limit.
        # If we can sort the list by the length of the word, we can reduce the time complexity.
        # The time complexity is O(n^2), which is too high.
        # We can use a dictionary to store the anagrams.
        # The time complexity is O(n).
        # The space complexity is O(n).
        result = []
        for word in words:
            if not result:
                result.append(word)
            else:
                for i in range(len(result)):
                    if self.isAnagram(word, result[i]):
                        break
                else:
                    result.append(word)
        return result
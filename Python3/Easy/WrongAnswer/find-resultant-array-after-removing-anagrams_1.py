class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        
        result = []
        for word in words:
            if not result:
                result.append(word)
            else:
                for i in range(len(result)):
                    if sorted(word) == sorted(result[i]):
                        break
                else:
                    result.append(word)
        return result
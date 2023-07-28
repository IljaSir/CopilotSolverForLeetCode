class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        
        count = 0
        for word in words:
            for i in word:
                if word.count(i) <= chars.count(i):
                    count += 1
                    continue
                else:
                    count = 0
                    break
        return count
class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        
        # # 1st solution
        # # Time  complexity: O(sum(len(word) * len(chars)) for word in words)
        # # Space complexity: O(sum(len(word) for word in words))
        # from collections import Counter
        # chars_counter = Counter(chars)
        # return sum(sum(Counter(word)[c] <= chars_counter[c] for c in word) == len(word) for word in words)
        # 2nd solution
        # Time  complexity: O(sum(len(word) * len(chars)) for word in words)
        # Space complexity: O(sum(len(word) for word in words))
        from collections import Counter
        chars_counter = Counter(chars)
        return sum(sum(chars_counter[c] >= Counter(word)[c] for c in word) == len(word) for word in words)
class Solution:
    def areOccurrencesEqual(self, s: str) -> bool:
        
        char_count = {}
        for char in s:
            if char in char_count:
                char_count[char] += 1
            else:
                char_count[char] = 1
        all_counts = []
        for char, count in char_count.items():
            all_counts.append(count)
        if len(set(all_counts)) == 1:
            return True
        return False
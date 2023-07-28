class Solution:
    def reorganizeString(self, s: str) -> str:
        
        n = len(s)
        if n == 1:
            return s
        char_count = collections.Counter(s)
        max_char = max(char_count.values())
        if max_char > (n+1)//2:
            return ""
        char_list = []
        for char, count in char_count.items():
            char_list.extend([char] * count)
        res = [None] * n
        res[::2], res[1::2] = char_list[n//2:], char_list[:n//2]
        return ''.join(res)
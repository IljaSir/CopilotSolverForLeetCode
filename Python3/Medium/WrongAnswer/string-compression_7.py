class Solution:
    def compress(self, chars: List[str]) -> int:
        
        if len(chars) == 1:
            return 1
        i = 0
        while i < len(chars)-1:
            if chars[i] == chars[i+1]:
                count = 1
                j = i+1
                while j < len(chars) and chars[j] == chars[i]:
                    count += 1
                    j += 1
                chars[i+1:j] = str(count)
                i += 2
            else:
                i += 1
        return len(chars)
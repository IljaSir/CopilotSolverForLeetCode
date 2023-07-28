class Solution:
    def compress(self, chars: List[str]) -> int:
        
        i = 0
        j = 0
        while i < len(chars):
            count = 1
            while j < len(chars) - 1 and chars[j] == chars[j+1]:
                count += 1
                j += 1
            if count > 1:
                chars[i+1:i+1] = list(str(count))
                i += len(str(count))
            i += 1
            j += 1
        return len(chars)
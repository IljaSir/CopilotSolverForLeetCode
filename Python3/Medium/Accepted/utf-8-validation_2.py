class Solution:
    def validUtf8(self, data: List[int]) -> bool:
        
        n = len(data)
        i = 0
        while i < n:
            if data[i] & 0b10000000 == 0:
                i += 1
            elif data[i] & 0b11100000 == 0b11000000:
                if i + 1 >= n or data[i + 1] & 0b11000000 != 0b10000000:
                    return False
                i += 2
            elif data[i] & 0b11110000 == 0b11100000:
                if i + 2 >= n or data[i + 1] & 0b11000000 != 0b10000000 or data[i + 2] & 0b11000000 != 0b10000000:
                    return False
                i += 3
            elif data[i] & 0b11111000 == 0b11110000:
                if i + 3 >= n or data[i + 1] & 0b11000000 != 0b10000000 or data[i + 2] & 0b11000000 != 0b10000000 or data[i + 3] & 0b11000000 != 0b10000000:
                    return False
                i += 4
            else:
                return False
        return True
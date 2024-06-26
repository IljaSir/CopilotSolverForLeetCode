class Solution:
    def validUtf8(self, data: List[int]) -> bool:
        
        n = len(data)
        i = 0
        while i < n:
            if data[i] >> 7 == 0:
                i += 1
            elif data[i] >> 5 == 0b110:
                if i+1 >= n or data[i+1] >> 6 != 0b10:
                    return False
                i += 2
            elif data[i] >> 4 == 0b1110:
                if i+2 >= n or data[i+1] >> 6 != 0b10 or data[i+2] >> 6 != 0b10:
                    return False
                i += 3
            elif data[i] >> 3 == 0b11110:
                if i+3 >= n or data[i+1] >> 6 != 0b10 or data[i+2] >> 6 != 0b10 or data[i+3] >> 6 != 0b10:
                    return False
                i += 4
            else:
                return False
        return True
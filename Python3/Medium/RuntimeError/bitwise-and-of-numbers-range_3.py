class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        
        if left == 0:
            return 0
        if left == right:
            return left
        if left == 1:
            return 0
        if left % 2 == 1:
            return 0
        if left % 4 == 0 and right % 4 == 3:
            return 0
        if left % 8 == 0 and right % 8 == 7:
            return 0
        if left % 16 == 0 and right % 16 == 15:
            return 0
        if left % 32 == 0 and right % 32 == 31:
            return 0
        if left % 64 == 0 and right % 64 == 63:
            return 0
        if left % 128 == 0 and right % 128 == 127:
            return 0
        if left % 256 == 0 and right % 256 == 255:
            return 0
        if left % 512 == 0 and right % 512 == 511:
            return 0
        if left % 1024 == 0 and right % 1024 == 1023:
            return 0
        if left % 2048 == 0 and right % 2048 == 2047:
            return 0
        if left % 4096 == 0 and right % 4096 == 4095:
            return 0
        if left % 8192 == 0 and right % 8192 == 8191:
            return 0
        if left % 16384 == 0 and right % 16384 == 16383:
            return 0
        if left % 32768 == 0 and right % 32768 == 32767:
            return 0
        if left % 65536 == 0 and right % 65536 == 65535:
            return 0
        if left % 131072 == 0 and right % 131072 == 131071:
            return 0
        if left % 262144 == 0 and right % 262144 == 262143:
            return 0
        if left % 524288 == 0 and right % 524288 == 524287:
            return 0
        if left % 104
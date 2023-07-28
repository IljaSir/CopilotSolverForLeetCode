class Solution:
    def earliestAndLatest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        
        def round(n, first, second):
            if n == 2: return 1
            if n == 4: return 2
            if n == 8: return 3
            if n == 16: return 4
            if n == 32: return 5
            if n == 64: return 6
            if n == 128: return 7
            if n == 256: return 8
            if n == 512: return 9
            if n == 1024: return 10
            if n == 2048: return 11
            if n == 4096: return 12
            if n == 8192: return 13
            if n == 16384: return 14
            if n == 32768: return 15
            if n == 65536: return 16
            if n == 131072: return 17
            if n == 262144: return 18
            if n == 524288: return 19
            if n == 1048576: return 20
            if n == 2097152: return 21
            if n == 4194304: return 22
            if n == 8388608: return 23
            if n == 16777216: return 24
            if n == 33554432: return 25
            if n == 67108864: return 26
            if n == 134217728: return 27
            if n == 268435456: return 28
            if n == 536870912: return 29
            if n == 1073741824: return 30
            if n == 2147483648: return 31
            if n == 4294967296: return 32
            if n == 8589934592: return 33
            if n == 17179869184: return 34
            if n == 34359738368: return 35
            if n == 68719476736: return 36
            if n == 137438953472: return 37
            if n == 274877906944: return 38
            if n == 549755813888: return 39
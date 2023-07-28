class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        
        if poured == 0:
            return 0
        if query_row == 0:
            return min(1, poured)
        if query_row == 1:
            return min(1, poured/2)
        if query_glass == 0:
            return min(1, poured/4)
        if query_glass == 1:
            return min(1, poured/2)
        if query_glass == 2:
            return min(1, poured/4)
        if query_glass == 3:
            return min(1, poured/8)
        if query_glass == 4:
            return min(1, poured/16)
        if query_glass == 5:
            return min(1, poured/32)
        if query_glass == 6:
            return min(1, poured/64)
        if query_glass == 7:
            return min(1, poured/128)
        if query_glass == 8:
            return min(1, poured/256)
        if query_glass == 9:
            return min(1, poured/512)
        if query_glass == 10:
            return min(1, poured/1024)
        if query_glass == 11:
            return min(1, poured/2048)
        if query_glass == 12:
            return min(1, poured/4096)
        if query_glass == 13:
            return min(1, poured/8192)
        if query_glass == 14:
            return min(1, poured/16384)
        if query_glass == 15:
            return min(1, poured/32768)
        if query_glass == 16:
            return min(1, poured/65536)
        if query_glass == 17:
            return min(1, poured/131072)
        if query_glass == 18:
            return min(1, poured/262144)
        if query_glass == 19:
            return min(1, poured/524288)
        if query_glass == 20:
            return min(1, poured/1048576)
        if query_glass == 21:
            return min(1, poured/2097152)
        if query_glass == 22:
            return min(1, poured/4194304)
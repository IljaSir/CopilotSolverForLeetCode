class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        
        if poured == 0:
            return 0
        if poured >= 100:
            return 1
        if query_row == 0:
            return poured / 100
        if query_row == 1:
            if poured >= 200:
                return 1
            return min(poured / 200, 0.5)
        if query_row == 2:
            if poured >= 300:
                return 1
            if poured >= 200:
                return 0.5 + (poured - 200) / 300
            return poured / 300
        if query_row == 3:
            if poured >= 400:
                return 1
            if poured >= 300:
                return 0.5 + (poured - 300) / 400
            return poured / 400
        if query_row == 4:
            if poured >= 500:
                return 1
            if poured >= 400:
                return 0.5 + (poured - 400) / 500
            return poured / 500
        if query_row == 5:
            if poured >= 600:
                return 1
            if poured >= 500:
                return 0.5 + (poured - 500) / 600
            return poured / 600
        if query_row == 6:
            if poured >= 700:
                return 1
            if poured >= 600:
                return 0.5 + (poured - 600) / 700
            return poured / 700
        if query_row == 7:
            if poured >= 800:
                return 1
            if poured >= 700:
                return 0.5 + (poured - 700) / 800
            return poured / 800
        if query_row == 8:
            if poured >= 900:
                return 1
            if poured >= 800:
                return 0.5 + (poured - 800) / 900
            return poured / 900
        if query_row == 9:
            if poured >= 1000:
                return 1
            if poured >= 900:
                return 0.5 + (poured - 900) / 1000
            return poured / 1000
        if query_row == 10
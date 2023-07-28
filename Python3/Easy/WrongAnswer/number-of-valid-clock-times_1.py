class Solution:
    def countTime(self, time: str) -> int:
        
        if time[0] == "?":
            if time[1] == "?":
                h = 24
            else:
                if int(time[1]) < 4:
                    h = 10
                else:
                    h = 8
        else:
            if time[1] == "?":
                if int(time[0]) == 2:
                    h = 4
                else:
                    h = 10
            else:
                h = 1
        if time[3] == "?":
            if time[4] == "?":
                m = 60
            else:
                m = 10
        else:
            if time[4] == "?":
                m = 10
            else:
                m = 1
        return h * m
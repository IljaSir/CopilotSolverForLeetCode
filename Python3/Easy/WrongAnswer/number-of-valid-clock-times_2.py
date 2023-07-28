class Solution:
    def countTime(self, time: str) -> int:
        
        if time[0] == "?":
            if time[1] == "?":
                hour = 24
            else:
                hour = 3 if int(time[1]) < 4 else 2
        else:
            if time[1] == "?":
                hour = 2 if int(time[0]) < 2 else 1
            else:
                hour = 1
        if time[3] == "?":
            if time[4] == "?":
                minute = 60
            else:
                minute = 6
        else:
            if time[4] == "?":
                minute = 10
            else:
                minute = 1
        return hour * minute
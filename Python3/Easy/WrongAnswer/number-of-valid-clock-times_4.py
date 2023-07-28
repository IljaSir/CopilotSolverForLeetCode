class Solution:
    def countTime(self, time: str) -> int:
        
        hour, minute = time.split(":")
        if hour[0] == "?":
            if hour[1] == "?":
                hour = 24
            elif int(hour[1]) < 4:
                hour = 2
            else:
                hour = 1
        elif hour[1] == "?":
            if int(hour[0]) == 2:
                hour = 4
            else:
                hour = 10
        else:
            hour = 1
        if minute[0] == "?":
            if minute[1] == "?":
                minute = 60
            else:
                minute = 10
        elif minute[1] == "?":
            minute = 10
        else:
            minute = 1
        return hour * minute
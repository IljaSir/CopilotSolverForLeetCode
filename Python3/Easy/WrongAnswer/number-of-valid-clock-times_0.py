class Solution:
    def countTime(self, time: str) -> int:
        
        if time[0] == '?' and time[1] == '?':
            h = 24
        elif time[0] == '?' or time[1] == '?':
            h = 10 if time[0] == '?' else 2
        else:
            h = 1 if int(time[0:2]) < 24 else 0
        if time[3] == '?' and time[4] == '?':
            m = 60
        elif time[3] == '?' or time[4] == '?':
            m = 10 if time[3] == '?' else 6
        else:
            m = 1 if int(time[3:5]) < 60 else 0
        return h * m
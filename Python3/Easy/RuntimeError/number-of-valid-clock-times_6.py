class Solution:
    def countTime(self, time: str) -> int:
        
        
        def countTime(self, time: str) -> int:
        if time[0] != '?' and time[1] != '?':
            if time[0] == '2':
                if time[1] <= '3':
                    return 1
                else:
                    return 0
            else:
                return 1
        if time[3] != '?' and time[4] != '?':
            if time[3] == '6' and time[4] >= '0':
                return 0
            else:
                return 1
        if time[0] != '?' and time[1] == '?':
            if time[0] == '2':
                return 4
            else:
                return 10
        if time[1] != '?' and time[0] == '?':
            if time[1] <= '3':
                return 2
            else:
                return 1
        if time[3] != '?' and time[4] == '?':
            if time[3] == '5':
                return 4
            else:
                return 10
        if time[4] != '?' and time[3] == '?':
            if time[4] <= '9':
                return 6
            else:
                return 1
        return 144
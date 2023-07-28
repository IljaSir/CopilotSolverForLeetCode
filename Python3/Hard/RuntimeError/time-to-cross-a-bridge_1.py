class Solution:
    def findCrossingTime(self, n: int, k: int, time: List[List[int]]) -> int:
        
        
        def get_time(i, j):
            if i == 0:
                return time[j][0] + time[j][2]
            else:
                return time[j][0] + time[j][2] + time[j][1] + time[j][3]
        
        def get_time2(i, j):
            if i == 0:
                return time[j][0] + time[j][2] + time[j][1] + time[j][3]
            else:
                return time[j][0] + time[j][2]
        
        def get_time3(i, j):
            if i == 0:
                return time[j][0] + time[j][2] + time[j][1] + time[j][3]
            else:
                return time[j][0] + time[j][2] + time[j][1] + time[j][3]
        
        def get_time4(i, j):
            if i == 0:
                return time[j][0] + time[j][2]
            else:
                return time[j][0] + time[j][2] + time[j][1] + time[j][3]
        
        def get_time5(i, j):
            if i == 0:
                return time[j][0] + time[j][2]
            else:
                return time[j][0] + time[j][2] + time[j][1] + time[j][3]
        
        def get_time6(i, j):
            if i == 0:
                return time[j][0] + time[j][2]
            else:
                return time[j][0] + time[j][2] + time[j][1] + time[j][3]
        
        def get_time7(i, j):
            if i == 0:
                return time[j][0] + time[j][2] + time[j][1] + time[j][3]
            else:
                return time[j][0] + time[j][2]
        
        def get_time8(i, j):
            if i == 0:
                return time[j][0] + time[j][2] + time[j][1] + time[j][3]
            else:
                return time[j][0] + time[j][2]
        
        def get_time9(i, j):
            if i == 0:
                return time[j][0]
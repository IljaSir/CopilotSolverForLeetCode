class Solution:
    def readBinaryWatch(self, turnedOn: int) -> List[str]:
        
        def get_hrs_mins(num):
            hrs = num // 60
            mins = num % 60
            return hrs, mins
        def get_binary(num):
            return bin(num)[2:]
        def get_num_ones(num):
            return get_binary(num).count('1')
        def get_time(num):
            hrs, mins = get_hrs_mins(num)
            if mins < 10:
                mins = '0' + str(mins)
            else:
                mins = str(mins)
            if hrs < 10:
                hrs = '0' + str(hrs)
            else:
                hrs = str(hrs)
            return hrs + ':' + mins
        times = []
        for i in range(0, 12*60):
            if get_num_ones(i) == turnedOn:
                times.append(get_time(i))
        return times
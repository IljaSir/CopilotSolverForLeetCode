class Solution:
    def readBinaryWatch(self, turnedOn: int) -> List[str]:
        
        def get_time(hour, minute):
            return str(hour) + ':' + str(minute).zfill(2)
        def get_time_list(hour, minute):
            return [hour, minute]
        def get_minutes_list(num):
            minutes = []
            for i in range(0, 60):
                if bin(i).count('1') == num:
                    minutes.append(i)
            return minutes
        def get_hour_list(num):
            hours = []
            for i in range(0, 12):
                if bin(i).count('1') == num:
                    hours.append(i)
            return hours
        hours = get_hour_list(turnedOn)
        minutes = get_minutes_list(turnedOn)
        if len(hours) == 0:
            hours = get_hour_list(turnedOn-1)
            minutes = get_minutes_list(1)
        if len(minutes) == 0:
            minutes = get_minutes_list(turnedOn-1)
            hours = get_hour_list(1)
        return [get_time(hour, minute) for hour in hours for minute in minutes]
class Solution:
    def daysBetweenDates(self, date1: str, date2: str) -> int:
        
        
        def get_days(date):
            year, month, day = date.split("-")
            year, month, day = int(year), int(month), int(day)
            days = 0
            for y in range(1971, year):
                days += 365
                if y % 4 == 0 and (y % 100 != 0 or y % 400 == 0):
                    days += 1
            days += (month - 1) * 30 + day
            if month > 2:
                days -= 3
            if month > 8:
                days -= 1
            if month > 11:
                days -= 1
            if month > 12:
                days -= 1
            if year % 4 == 0 and (year % 100 != 0 or year % 400 == 0):
                if month > 2:
                    days += 1
            return days
        return abs(get_days(date1) - get_days(date2))
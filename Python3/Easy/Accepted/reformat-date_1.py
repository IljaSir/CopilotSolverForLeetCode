class Solution:
    def reformatDate(self, date: str) -> str:
        
        month = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
        date = date.split()
        day = date[0][:-2]
        if len(day) == 1:
            day = "0" + day
        month = str(month.index(date[1]) + 1)
        if len(month) == 1:
            month = "0" + month
        return date[2] + "-" + month + "-" + day
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        if k == 0:
            return num
        if k == len(num):
            return "0"
        if k == len(num) - 1:
            return str(min(int(num[i]) for i in range(len(num))))
        if k == 1:
            if num[0] == "1":
                return str(min(int(num[i]) for i in range(1, len(num))))
            else:
                return num[1:]
        if k == 2:
            if num[0] == "1":
                return str(min(int(num[i]) for i in range(2, len(num))))
            else:
                return num[2:]
        if k == 3:
            if num[0] == "1":
                return str(min(int(num[i]) for i in range(3, len(num))))
            else:
                return num[3:]
        if k == 4:
            if num[0] == "1":
                return str(min(int(num[i]) for i in range(4, len(num))))
            else:
                return num[4:]
        if k == 5:
            if num[0] == "1":
                return str(min(int(num[i]) for i in range(5, len(num))))
            else:
                return num[5:]
        if k == 6:
            if num[0] == "1":
                return str(min(int(num[i]) for i in range(6, len(num))))
            else:
                return num[6:]
        if k == 7:
            if num[0] == "1":
                return str(min(int(num[i]) for i in range(7, len(num))))
            else:
                return num[7:]
        if k == 8:
            if num[0] == "1":
                return str(min(int(num[i]) for i in range(8, len(num))))
            else:
                return num[8:]
        if k == 9:
            if num[0] == "1":
                return str(min(int(num[i]) for i in range(9, len(num))))
            else:
                return num[9:]
        if k == 10:
            if num[0] == "1":
                return str(min(int(num[i]) for i in range(10, len(num))))
            else:
                return num[10:]
        if k == 11:
            if num
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        if k == len(num):
            return "0"
        if k == 0:
            return num
        if len(num) == 1:
            return "0"
        if len(num) == 2:
            if k == 1:
                return "0"
            else:
                return num
        if len(num) == 3:
            if k == 1:
                if num[0] < num[1] and num[0] < num[2]:
                    return num[1:]
                elif num[1] < num[0] and num[1] < num[2]:
                    return num[0] + num[2]
                else:
                    return num[:2]
            elif k == 2:
                if num[0] < num[1] and num[0] < num[2]:
                    return num[2]
                elif num[1] < num[0] and num[1] < num[2]:
                    return num[0]
                else:
                    return num[1]
            else:
                return num
        if k == 1:
            if num[0] < num[1]:
                return self.removeKdigits(num[1:], k-1)
            else:
                return num[0] + self.removeKdigits(num[2:], k-1)
        elif k == 2:
            if num[0] < num[1] and num[0] < num[2]:
                return self.removeKdigits(num[1:], k-1)
            elif num[1] < num[0] and num[1] < num[2]:
                return num[0] + self.removeKdigits(num[2:], k-1)
            else:
                return num[0] + self.removeKdigits(num[1:], k-2)
        elif k == 3:
            if num[0] < num[1] and num[0] < num[2]:
                return self.removeKdigits(num[1:], k-1)
            elif num[1] < num[0] and num[1] < num[2]:
                return num[0] + self.removeKdigits(num[2:], k-1)
            else:
                return num[0] + self.removeKdigits(num[1:], k-2)
        elif k == 4:
            if num[
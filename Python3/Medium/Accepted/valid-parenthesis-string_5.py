class Solution:
    def checkValidString(self, s: str) -> bool:
        
        left = []
        star = []
        for i in range(len(s)):
            if s[i] == "(":
                left.append(i)
            elif s[i] == "*":
                star.append(i)
            else:
                if len(left) > 0:
                    left.pop()
                elif len(star) > 0:
                    star.pop()
                else:
                    return False
        while len(left) > 0 and len(star) > 0:
            if left[-1] > star[-1]:
                return False
            left.pop()
            star.pop()
        return len(left) == 0
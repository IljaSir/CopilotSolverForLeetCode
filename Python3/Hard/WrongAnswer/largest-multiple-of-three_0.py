class Solution:
    def largestMultipleOfThree(self, digits: List[int]) -> str:
        
        digits.sort(reverse=True)
        n = len(digits)
        s = sum(digits)
        if s % 3 == 1:
            for i in range(n):
                if digits[i] % 3 == 1:
                    digits.pop(i)
                    break
            else:
                for i in range(n):
                    if digits[i] % 3 == 2:
                        digits.pop(i)
                        break
                else:
                    return ""
                for i in range(n-1):
                    if digits[i] % 3 == 2:
                        digits.pop(i)
                        break
                else:
                    return ""
        elif s % 3 == 2:
            for i in range(n):
                if digits[i] % 3 == 2:
                    digits.pop(i)
                    break
            else:
                for i in range(n):
                    if digits[i] % 3 == 1:
                        digits.pop(i)
                        break
                else:
                    return ""
                for i in range(n-1):
                    if digits[i] % 3 == 1:
                        digits.pop(i)
                        break
                else:
                    return ""
        return "".join(map(str, digits)) if digits[-1] != 0 else "0"
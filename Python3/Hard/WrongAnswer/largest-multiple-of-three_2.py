class Solution:
    def largestMultipleOfThree(self, digits: List[int]) -> str:
        
        digits.sort(reverse=True)
        if digits[0] == 0:
            return "0"
        if sum(digits) % 3 == 0:
            return "".join(map(str, digits))
        if sum(digits) % 3 == 1:
            for i, v in enumerate(digits):
                if v % 3 == 1:
                    digits.pop(i)
                    break
            else:
                for i, v in enumerate(digits):
                    if v % 3 == 2:
                        digits.pop(i)
                        if i < len(digits):
                            digits.pop(i)
                            break
                else:
                    return ""
        else:
            for i, v in enumerate(digits):
                if v % 3 == 2:
                    digits.pop(i)
                    break
            else:
                for i, v in enumerate(digits):
                    if v % 3 == 1:
                        digits.pop(i)
                        if i < len(digits):
                            digits.pop(i)
                            break
                else:
                    return ""
        return "".join(map(str, digits))
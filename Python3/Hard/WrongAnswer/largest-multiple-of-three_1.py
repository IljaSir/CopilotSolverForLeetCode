class Solution:
    def largestMultipleOfThree(self, digits: List[int]) -> str:
        
        digits.sort(reverse=True)
        if digits[0] == 0:
            return '0'
        s = sum(digits)
        if s % 3 == 1:
            for i in range(len(digits)):
                if digits[i] % 3 == 1:
                    digits.pop(i)
                    break
            else:
                for i in range(len(digits)):
                    if digits[i] % 3 == 2:
                        digits.pop(i)
                        break
                else:
                    return ''
                for i in range(len(digits)):
                    if digits[i] % 3 == 2:
                        digits.pop(i)
                        break
                else:
                    return ''
        elif s % 3 == 2:
            for i in range(len(digits)):
                if digits[i] % 3 == 2:
                    digits.pop(i)
                    break
            else:
                for i in range(len(digits)):
                    if digits[i] % 3 == 1:
                        digits.pop(i)
                        break
                else:
                    return ''
                for i in range(len(digits)):
                    if digits[i] % 3 == 1:
                        digits.pop(i)
                        break
                else:
                    return ''
        return ''.join(map(str, digits))
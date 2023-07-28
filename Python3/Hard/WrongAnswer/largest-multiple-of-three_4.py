class Solution:
    def largestMultipleOfThree(self, digits: List[int]) -> str:
        
        digits.sort(reverse=True)
        if digits[-1] == 0:
            return "0"
        if sum(digits) % 3 == 0:
            return "".join(map(str, digits))
        if sum(digits) % 3 == 1:
            for i in range(0, len(digits), 3):
                if digits[i] % 3 == 1:
                    digits.pop(i)
                    return "".join(map(str, digits))
            for i in range(1, len(digits), 3):
                if digits[i] % 3 == 1:
                    digits.pop(i)
                    digits.pop(i-1)
                    return "".join(map(str, digits))
            for i in range(2, len(digits), 3):
                if digits[i] % 3 == 1:
                    digits.pop(i)
                    digits.pop(i-1)
                    digits.pop(i-2)
                    return "".join(map(str, digits))
        if sum(digits) % 3 == 2:
            for i in range(0, len(digits), 3):
                if digits[i] % 3 == 2:
                    digits.pop(i)
                    return "".join(map(str, digits))
            for i in range(1, len(digits), 3):
                if digits[i] % 3 == 2:
                    digits.pop(i)
                    digits.pop(i-1)
                    return "".join(map(str, digits))
            for i in range(2, len(digits), 3):
                if digits[i] % 3 == 2:
                    digits.pop(i)
                    digits.pop(i-1)
                    digits.pop(i-2)
                    return "".join(map(str, digits))
        return ""
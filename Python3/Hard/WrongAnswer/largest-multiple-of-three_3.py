class Solution:
    def largestMultipleOfThree(self, digits: List[int]) -> str:
        
        digits.sort(reverse=True)
        if digits[0] == 0:
            return "0"
        if sum(digits) % 3 == 0:
            return "".join(map(str, digits))
        if sum(digits) % 3 == 1:
            for i, d in enumerate(digits):
                if d % 3 == 1:
                    return "".join(map(str, digits[:i] + digits[i+1:]))
            for i, d in enumerate(digits):
                if d % 3 == 2:
                    for j, d2 in enumerate(digits[i+1:]):
                        if d2 % 3 == 2:
                            return "".join(map(str, digits[:i] + digits[i+1:i+1+j] + digits[i+1+j+1:]))
        if sum(digits) % 3 == 2:
            for i, d in enumerate(digits):
                if d % 3 == 2:
                    return "".join(map(str, digits[:i] + digits[i+1:]))
            for i, d in enumerate(digits):
                if d % 3 == 1:
                    for j, d2 in enumerate(digits[i+1:]):
                        if d2 % 3 == 1:
                            return "".join(map(str, digits[:i] + digits[i+1:i+1+j] + digits[i+1+j+1:]))
        return ""
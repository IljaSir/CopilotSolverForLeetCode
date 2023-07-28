class Solution:
    def largestMultipleOfThree(self, digits: List[int]) -> str:
        
        digits.sort(reverse=True)
        if digits[0] == 0: return '0'
        if sum(digits) % 3 == 0: return ''.join(map(str, digits))
        if sum(digits) % 3 == 1:
            for i, d in enumerate(digits):
                if d % 3 == 1:
                    digits.pop(i)
                    return ''.join(map(str, digits)) or '0'
            for i, d in enumerate(digits):
                if d % 3 == 2:
                    digits.pop(i)
                    break
            for i, d in enumerate(digits):
                if d % 3 == 2:
                    digits.pop(i)
                    return ''.join(map(str, digits)) or '0'
        if sum(digits) % 3 == 2:
            for i, d in enumerate(digits):
                if d % 3 == 2:
                    digits.pop(i)
                    return ''.join(map(str, digits)) or '0'
            for i, d in enumerate(digits):
                if d % 3 == 1:
                    digits.pop(i)
                    break
            for i, d in enumerate(digits):
                if d % 3 == 1:
                    digits.pop(i)
                    return ''.join(map(str, digits)) or '0'
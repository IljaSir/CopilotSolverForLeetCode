class Solution:
    def largestMultipleOfThree(self, digits: List[int]) -> str:
        
        digits.sort(reverse=True)
        if digits[0] == 0:
            return "0"
        r = sum(digits) % 3
        if r == 0:
            return "".join(str(d) for d in digits)
        s = set()
        for i, d in enumerate(digits):
            if d % 3 == r:
                s.add(i)
        if len(s) == 0:
            for i, d in enumerate(digits):
                if d % 3 == 3 - r:
                    s.add(i)
            for i, d in enumerate(digits):
                if d % 3 == 3 - r:
                    if i not in s:
                        s.add(i)
                        break
            for i, d in enumerate(digits):
                if d % 3 == 3 - r:
                    if i not in s:
                        s.add(i)
                        break
        if len(s) < 3:
            return ""
        return "".join(str(d) for i, d in enumerate(digits) if i not in s)
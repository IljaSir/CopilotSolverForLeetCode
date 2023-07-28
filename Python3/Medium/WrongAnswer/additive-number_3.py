class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        
        def is_additive_number(num, i, j):
            if i > 0 and num[0] == "0":
                return False
            if j - i > 1 and num[i] == "0":
                return False
            a, b = int(num[:i]), int(num[i:j])
            while j < len(num):
                a, b = b, a + b
                if num[j:].startswith(str(b)):
                    j += len(str(b))
                else:
                    return False
            return True
        for i in range(1, len(num)):
            for j in range(i + 1, len(num)):
                if is_additive_number(num, i, j):
                    return True
        return False
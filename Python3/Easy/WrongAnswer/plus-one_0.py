class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        
        if len(digits) == 1:
            if digits[0] == 9:
                return [1,0]
            else:
                return [digits[0]+1]
        else:
            if digits[-1] == 9:
                digits[-1] = 0
                digits[-2] += 1
                if digits[-2] == 10:
                    digits[-2] = 0
                    digits.insert(0,1)
                return digits
            else:
                digits[-1] += 1
                return digits
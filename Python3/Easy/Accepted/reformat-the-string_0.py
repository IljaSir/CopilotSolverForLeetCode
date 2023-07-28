class Solution:
    def reformat(self, s: str) -> str:
        
        letters = []
        digits = []
        for i in s:
            if i.isalpha():
                letters.append(i)
            else:
                digits.append(i)
        if abs(len(letters) - len(digits)) > 1:
            return ""
        if len(letters) > len(digits):
            return "".join([s1+s2 for s1,s2 in zip(letters, digits + [""])])
        else:
            return "".join([s1+s2 for s1,s2 in zip(digits, letters + [""])])
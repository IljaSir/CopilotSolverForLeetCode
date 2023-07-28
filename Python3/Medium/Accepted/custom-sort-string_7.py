class Solution:
    def customSortString(self, order: str, s: str) -> str:
        
        # sort the string s based on the order of characters in the string order
        # return the sorted string
        # for each character in order, find it in s
        # if it is in s, add it to the new string
        # remove it from s
        # add the remaining characters in s to the new string
        new = ""
        for c in order:
            if c in s:
                new += c * s.count(c)
                s = s.replace(c, "")
        new += s
        return new
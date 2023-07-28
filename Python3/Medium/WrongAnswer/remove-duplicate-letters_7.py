class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        
        # 1. find the smallest char that is the last char in the string
        # 2. find the first index of the smallest char
        # 3. remove the smallest char and repeat
        # 4. return the result
        if len(s) == 0:
            return ""
        smallest = min(s)
        smallest_index = s.rindex(smallest)
        return smallest + self.removeDuplicateLetters(s[smallest_index+1:].replace(smallest, ""))
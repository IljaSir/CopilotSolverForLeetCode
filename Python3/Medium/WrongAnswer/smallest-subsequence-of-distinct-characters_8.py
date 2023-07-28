class Solution:
    def smallestSubsequence(self, s: str) -> str:
        
        # 1. find the smallest char in s
        # 2. find the last index of this char
        # 3. if there is another smallest char in between the first and last index, then remove the first char and repeat
        # 4. if there is no other smallest char in between the first and last index, then add the first char to the result and remove it from s
        # 5. repeat from 1 until s is empty
        # 6. return the result
        result = ""
        while s:
            smallest_char = min(s)
            last_index = s.rfind(smallest_char)
            if smallest_char in s[1:last_index]:
                s = s.replace(smallest_char, "", 1)
            else:
                result += smallest_char
                s = s.replace(smallest_char, "", 1)
        return result
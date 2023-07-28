class Solution:
    def smallestNumber(self, pattern: str) -> str:
        
        result = ""
        for i in range(1, len(pattern)):
            if pattern[i] != pattern[i - 1]:
                result += str(i)
        result += str(len(pattern))
        return result
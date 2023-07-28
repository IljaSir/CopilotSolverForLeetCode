class Solution:
    def numDifferentIntegers(self, word: str) -> int:
        
        # 1 <= word.length <= 1000
        # word consists of digits and lowercase English letters.
        # Replace every non-digit character with a space.
        # Return the number of different integers after performing the replacement operations on word.
        # Two integers are considered different if their decimal representations without any leading zeros are different.
        # 1. Replace every non-digit character with a space
        # 2. Split the string
        # 3. Remove the leading zeros
        # 4. Remove the empty strings
        # 5. Return the length
        return len(set([int(i) for i in word.replace("a", " ").replace("b", " ").replace("c", " ").replace("d", " ").replace("e", " ").replace("f", " ").replace("g", " ").replace("h", " ").replace("i", " ").replace("j", " ").replace("k", " ").replace("l", " ").replace("m", " ").replace("n", " ").replace("o", " ").replace("p", " ").replace("q", " ").replace("r", " ").replace("s", " ").replace("t", " ").replace("u", " ").replace("v", " ").replace("w", " ").replace("x", " ").replace("y", " ").replace("z", " ").split() if i != ""]))
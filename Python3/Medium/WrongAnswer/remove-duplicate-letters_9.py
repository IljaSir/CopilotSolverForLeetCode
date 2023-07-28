class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        
        # 1. count frequency of each letter
        # 2. find the smallest letter in the current string
        # 3. if the smallest letter is not the first letter in the current string, remove it
        # 4. if the smallest letter is the first letter in the current string, remove all the duplicate letters in the current string and add it to the result
        # 5. remove the first letter in the current string and repeat step 2-4
        # 6. return the result
        # time complexity: O(n^2)
        # space complexity: O(n)
        freq = {}
        for letter in s:
            if letter not in freq:
                freq[letter] = 0
            freq[letter] += 1
        result = ""
        while len(s) > 0:
            smallest_letter = min(s)
            if s[0] != smallest_letter:
                s = s[1:]
                freq[smallest_letter] -= 1
            else:
                while len(s) > 0 and s[0] == smallest_letter:
                    s = s[1:]
                    freq[smallest_letter] -= 1
                result += smallest_letter
        return result
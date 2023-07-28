class Solution:
    def minDeletions(self, s: str) -> int:
        
        # 1. Count the frequency of each character
        # 2. Sort the frequency in descending order
        # 3. Iterate the frequency list, if there is a duplicate, then decrease the frequency by 1 and increase the deletion number by 1
        # 4. Repeat step 3 until there is no duplicate
        freq = {}
        for c in s:
            freq[c] = freq.get(c, 0) + 1
        freq = sorted(freq.values(), reverse=True)
        deletion = 0
        for i in range(1, len(freq)):
            if freq[i] == 0: break
            while freq[i] >= freq[i-1]:
                freq[i] -= 1
                deletion += 1
        return deletion
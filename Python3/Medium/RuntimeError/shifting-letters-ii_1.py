class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        
        # 1st solution
        # Time  complexity: O(n)
        # Space complexity: O(n)
        # n = len(s)
        # shifts = [sum(shifts[i][2] * (26 ** (shifts[i][1] - shifts[i][0])) for i in range(len(shifts)))]
        # for i in range(len(shifts) - 2, -1, -1):
        #     shifts[i] = shifts[i + 1] + shifts[i]
        # return "".join(chr((ord(s[i]) - ord("a") + shifts[i]) % 26 + ord("a")) for i in range(len(s)))
        # 2nd solution
        # Time  complexity: O(n)
        # Space complexity: O(n)
        n = len(s)
        shifts = [sum(shifts[i][2] * (26 ** (shifts[i][1] - shifts[i][0])) for i in range(len(shifts)))]
        for i in range(len(shifts) - 2, -1, -1):
            shifts[i] = shifts[i + 1] + shifts[i]
        return "".join(chr((ord(s[i]) - ord("a") + shifts[i]) % 26 + ord("a")) for i in range(len(s)))
class Solution:
    def getMaxLen(self, nums: List[int]) -> int:
        
        # 1st: find the first negative number
        # 2nd: find the first positive number after 1st
        # 3rd: find the last negative number before 1st
        # 4th: find the last positive number before 1st
        # 5th: compare 1st and 2nd
        # 6th: compare 3rd and 4th
        # 7th: compare 5th and 6th
        # 8th: compare 7th and 0
        # 9th: return 8th
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        
        # 1. Count the number of people who trust each person
        # 2. Count the number of people who are trusted by each person
        # 3. Find the person who is trusted by everyone and trusts no one
        # 4. If there are multiple such people, return -1
        # 5. If there is no such person, return -1
        # 6. If the town judge exists, return the town judge's label
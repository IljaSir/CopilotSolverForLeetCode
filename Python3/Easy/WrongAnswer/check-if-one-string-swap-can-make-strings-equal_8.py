class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        
        # if s1 == s2:
        #     return True
        # # print(s1, s2)
        # for i in range(len(s1)):
        #     for j in range(i+1, len(s1)):
        #         # print(i, j)
        #         if s1[:i] + s1[j] + s1[i+1:j] + s1[i] + s1[j+1:] == s2:
        #             return True
        # return False
        return len(set(zip(s1, s2))) in {0, 2} and sorted(s1) == sorted(s2)
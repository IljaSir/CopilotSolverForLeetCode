class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        
        if len(s1) + len(s2) != len(s3):
            return False
        if not s1:
            return s2 == s3
        if not s2:
            return s1 == s3
        if s1[0] != s3[0] and s2[0] != s3[0]:
            return False
        if s1[0] == s3[0]:
            if self.isInterleave(s1[1:], s2, s3[1:]):
                return True
        if s2[0] == s3[0]:
            if self.isInterleave(s1, s2[1:], s3[1:]):
                return True
        return False
class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        
        return len(set(map(lambda x: x.replace('.', '').split('+')[0] + x.split('@')[1], emails)))
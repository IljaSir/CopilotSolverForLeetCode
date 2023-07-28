class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        
        return len(set([x.split('@')[0].replace('.', '').split('+')[0]+'@'+x.split('@')[1] for x in emails]))
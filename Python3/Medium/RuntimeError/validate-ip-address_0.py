class Solution:
    def validIPAddress(self, queryIP: str) -> str:
        
        if '.' in queryIP:
            if self.is_valid_ipv4(queryIP):
                return 'IPv4'
            else:
                return 'Neither'
        elif ':' in queryIP:
            if self.is_valid_ipv6(queryIP):
                return 'IPv6'
            else:
                return 'Neither'
        else:
            return 'Neither'
class Solution:
    def validIPAddress(self, queryIP: str) -> str:
        
        if queryIP.count('.') == 3:
            for i in queryIP.split('.'):
                if not i.isdigit() or not 0 <= int(i) <= 255 or (i[0] == '0' and len(i) > 1):
                    return "Neither"
            return "IPv4"
        elif queryIP.count(':') == 7:
            for i in queryIP.split(':'):
                if not i.isalnum() or not 1 <= len(i) <= 4 or not all(c in '0123456789abcdefABCDEF' for c in i):
                    return "Neither"
            return "IPv6"
        else:
            return "Neither"
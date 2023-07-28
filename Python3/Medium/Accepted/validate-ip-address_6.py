class Solution:
    def validIPAddress(self, queryIP: str) -> str:
        
        if queryIP.count('.') == 3:
            try:
                return 'IPv4' if all(0 <= int(x) <= 255 and str(int(x)) == x for x in queryIP.split('.')) else 'Neither'
            except:
                return 'Neither'
        elif queryIP.count(':') == 7:
            try:
                return 'IPv6' if all(1 <= len(x) <= 4 and int(x, 16) >= 0 for x in queryIP.split(':')) else 'Neither'
            except:
                return 'Neither'
        else:
            return 'Neither'
class Solution:
    def validIPAddress(self, queryIP: str) -> str:
        
        if queryIP.count('.') == 3:
            try:
                return 'IPv4' if all(0 <= int(i) <= 255 and str(int(i)) == i for i in queryIP.split('.')) else 'Neither'
            except:
                return 'Neither'
        elif queryIP.count(':') == 7:
            try:
                return 'IPv6' if all(0 < len(i) <= 4 and int(i, 16) >= 0 for i in queryIP.split(':')) else 'Neither'
            except:
                return 'Neither'
        return 'Neither'
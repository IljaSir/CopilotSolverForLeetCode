class Solution:
    def validIPAddress(self, queryIP: str) -> str:
        
        def isIPv4(queryIP):
            try:
                return str(int(queryIP)) == queryIP and 0 <= int(queryIP) <= 255
            except:
                return False
        def isIPv6(queryIP):
            if len(queryIP) > 4:
                return False
            try:
                return int(queryIP, 16) >= 0 and queryIP[0] != '-'
            except:
                return False
        if queryIP.count('.') == 3 and all(isIPv4(x) for x in queryIP.split('.')):
            return "IPv4"
        if queryIP.count(':') == 7 and all(isIPv6(x) for x in queryIP.split(':')):
            return "IPv6"
        return "Neither"
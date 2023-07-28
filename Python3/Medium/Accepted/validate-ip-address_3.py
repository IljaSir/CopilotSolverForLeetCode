class Solution:
    def validIPAddress(self, queryIP: str) -> str:
        
        if queryIP.count('.') == 3:
            nums = queryIP.split('.')
            for x in nums:
                if not x or len(x) > 3 or (x[0] == '0' and len(x) != 1) or not x.isdigit() or int(x) > 255:
                    return "Neither"
            return "IPv4"
        elif queryIP.count(':') == 7:
            nums = queryIP.split(':')
            hexdigits = '0123456789abcdefABCDEF'
            for x in nums:
                if not x or len(x) > 4 or not all(c in hexdigits for c in x):
                    return "Neither"
            return "IPv6"
        return "Neither"
class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        if len(s) > 12:
            return []
        res = []
        for i in range(1,4):
            for j in range(1,4):
                for k in range(1,4):
                    for l in range(1,4):
                        if i+j+k+l == len(s):
                            p1 = int(s[0:i])
                            p2 = int(s[i:i+j])
                            p3 = int(s[i+j:i+j+k])
                            p4 = int(s[i+j+k:i+j+k+l])
                            if p1 <= 255 and p2 <= 255 and p3 <= 255 and p4 <= 255:
                                ip = str(p1)+'.'+str(p2)+'.'+str(p3)+'.'+str(p4)
                                if len(ip) == len(s)+3:
                                    res.append(ip)
        return res
class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        
        d = {}
        for s in cpdomains:
            n, s = s.split(' ')
            n = int(n)
            if not s in d:
                d[s] = n
            else:
                d[s] += n
            while '.' in s:
                s = s[s.find('.')+1:]
                if not s in d:
                    d[s] = n
                else:
                    d[s] += n
        return [str(v)+' '+k for k, v in d.items()]
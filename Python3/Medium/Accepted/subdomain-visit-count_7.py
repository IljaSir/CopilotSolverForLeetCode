class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        
        res = {}
        for i in cpdomains:
            num, domain = i.split()
            num = int(num)
            domain = domain.split('.')
            for i in range(len(domain)):
                temp = '.'.join(domain[i:])
                if temp in res:
                    res[temp] += num
                else:
                    res[temp] = num
        return [str(res[i]) + ' ' + i for i in res]
class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        
        d = {}
        for cpdomain in cpdomains:
            count, domain = cpdomain.split(' ')
            count = int(count)
            d[domain] = d.get(domain, 0) + count
            for i in range(len(domain)):
                if domain[i] == '.':
                    d[domain[i+1:]] = d.get(domain[i+1:], 0) + count
        return [str(count) + ' ' + domain for domain, count in d.items()]
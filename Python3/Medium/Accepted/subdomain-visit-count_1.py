class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        
        domains = {}
        for cpdomain in cpdomains:
            count, domain = cpdomain.split()
            count = int(count)
            parts = domain.split('.')
            for i in range(len(parts)):
                subdomain = '.'.join(parts[i:])
                domains[subdomain] = domains.get(subdomain, 0) + count
        return [f"{count} {domain}" for domain, count in domains.items()]
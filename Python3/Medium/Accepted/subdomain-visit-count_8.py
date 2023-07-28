class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        
        domain_dic = {}
        for cpdomain in cpdomains:
            count, domain = cpdomain.split(' ')
            count = int(count)
            domain_list = domain.split('.')
            for i in range(len(domain_list)):
                domain = '.'.join(domain_list[i:])
                if domain in domain_dic:
                    domain_dic[domain] += count
                else:
                    domain_dic[domain] = count
        return [str(v) + ' ' + k for k, v in domain_dic.items()]
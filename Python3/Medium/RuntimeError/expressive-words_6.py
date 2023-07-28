class Solution:
    def expressiveWords(self, s: str, words: List[str]) -> int:
        
def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        domain_dict = {}
        for cpdomain in cpdomains:
            num, domain = cpdomain.split(' ')
            num = int(num)
            domain_list = domain.split('.')
            for i in range(len(domain_list)):
                sub_domain = '.'.join(domain_list[i:])
                if sub_domain in domain_dict:
                    domain_dict[sub_domain] += num
                else:
                    domain_dict[sub_domain] = num
        return [str(value) + ' ' + key for key, value in domain_dict.items()]
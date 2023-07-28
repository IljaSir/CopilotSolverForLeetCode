class Solution:
    def totalStrength(self, strength: List[int]) -> int:
        
        # sum of total strength of wizards
        # 1 <= strength.length <= 10^5
        # 1 <= strength[i] <= 10^9
        # return the sum of the total strengths of all contiguous groups of wizards
        # total strength is defined as the product of the following two values:
        # 1. the strength of the weakest wizard in the group
        # 2. the total of all the individual strengths of the wizards in the group
        # brute force
        # O(n^2) time
        # O(1) space
        # total = 0
        # for i in range(len(strength)):
        #     for j in range(i, len(strength)):
        #         total += min(strength[i:j+1]) * sum(strength[i:j+1])
        # return total % (10**9 + 7)
        # the product of the following two values:
        # 1. the strength of the weakest wizard in the group
        # 2. the total of all the individual strengths of the wizards in the group
        # brute force
        # O(n^2) time
        # O(1) space
        # total = 0
        # for i in range(len(strength)):
        #     for j in range(i, len(strength)):
        #         total += min(strength[i:j+1]) * sum(strength[i:j+1])
        # return total % (10**9 + 7)
        # the product of the following two values:
        # 1. the strength of the weakest wizard in the group
        # 2. the total of all the individual strengths of the wizards in the group
        # brute force
        # O(n^2) time
        # O(1) space
        # total = 0
        # for i in range(len(strength)):
        #     for j in range(i, len(strength)):
        #         total += min(strength[i:j+1]) * sum(strength[i:j+1])
        # return total % (10**9 + 7)
        # the product of the following two values:
        # 1. the strength of the weakest wizard in the group
        # 2. the total of all the individual strengths of the wizards in the group
        # brute force
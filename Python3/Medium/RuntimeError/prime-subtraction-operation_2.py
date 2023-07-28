class Solution:
    def primeSubOperation(self, nums: List[int]) -> bool:
        
        primes = self.get_primes()
        for i in range(len(nums)):
            for p in primes:
                if nums[i] % p == 0:
                    nums[i] -= p
                    break
        print(nums)
        return all(nums[i] < nums[i+1] for i in range(len(nums)-1))
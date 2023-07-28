impl Solution {
    pub fn prime_sub_operation(nums: Vec<i32>) -> bool {
        
        let mut nums = nums;
        let mut primes = Vec::new();
        let mut i = 2;
        while primes.len() < 1000 {
            if is_prime(i) {
                primes.push(i);
            }
            i += 1;
        }
        let mut i = 0;
        let mut j = 0;
        while i < nums.len() {
            while j < primes.len() && nums[i] <= primes[j] {
                j += 1;
            }
            if j >= primes.len() {
                return false;
            }
            nums[i] -= primes[j];
            if i > 0 && nums[i] <= nums[i-1] {
                return false;
            }
            i += 1;
        }
        true
    }
}
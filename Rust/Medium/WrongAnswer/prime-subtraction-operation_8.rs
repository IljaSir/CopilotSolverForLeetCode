impl Solution {
    pub fn prime_sub_operation(nums: Vec<i32>) -> bool {
        
        let mut nums = nums;
        let mut primes = vec![2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31];
        let mut used = vec![false; nums.len()];
        let mut i = 0;
        while i < nums.len() {
            if used[i] {
                i += 1;
                continue;
            }
            let mut j = i + 1;
            while j < nums.len() {
                if used[j] {
                    j += 1;
                    continue;
                }
                let mut k = 0;
                while k < primes.len() {
                    if primes[k] >= nums[j] {
                        break;
                    }
                    k += 1;
                }
                if k == 0 {
                    return false;
                }
                if nums[j] - primes[k - 1] >= nums[i] {
                    nums[j] -= primes[k - 1];
                    used[j] = true;
                    j = i + 1;
                } else {
                    j += 1;
                }
            }
            i += 1;
        }
        true
    }
}
impl Solution {
    pub fn prime_sub_operation(nums: Vec<i32>) -> bool {
        
        let mut nums = nums;
        let mut primes = vec![2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97];
        for i in 0..nums.len() {
            let mut j = 0;
            while j < primes.len() {
                if nums[i] > primes[j] {
                    nums[i] -= primes[j];
                    j = 0;
                } else {
                    j += 1;
                }
            }
        }
        for i in 1..nums.len() {
            if nums[i] <= nums[i-1] {
                return false;
            }
        }
        true
    }
}
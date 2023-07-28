impl Solution {
    pub fn prime_sub_operation(nums: Vec<i32>) -> bool {
        
        let primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97];
        let mut i = 0;
        while i < nums.len() - 1 {
            if nums[i] <= nums[i+1] {
                i += 1;
                continue;
            }
            for p in primes.iter().rev() {
                if nums[i] > *p {
                    nums[i] -= p;
                    break;
                }
            }
            if nums[i] <= nums[i+1] {
                i = 0;
            }
        }
        true
    }
}
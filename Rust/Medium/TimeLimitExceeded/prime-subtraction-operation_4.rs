impl Solution {
    pub fn prime_sub_operation(nums: Vec<i32>) -> bool {
        
        let mut nums = nums;
        let mut primes = vec![2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97];
        let mut i = 0;
        while i < nums.len() - 1 {
            if nums[i] > nums[i + 1] {
                let mut j = 0;
                while j < primes.len() {
                    if nums[i] > primes[j] {
                        nums[i] -= primes[j];
                        j = 0;
                    } else {
                        j += 1;
                    }
                }
                i = 0;
            } else {
                i += 1;
            }
        }
        for i in 0..nums.len() - 1 {
            if nums[i] >= nums[i + 1] {
                return false;
            }
        }
        true
    }
}
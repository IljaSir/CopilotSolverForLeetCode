impl Solution {
    pub fn find_valid_split(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut prefix = vec![1; n];
        let mut suffix = vec![1; n];
        for i in 0..n {
            prefix[i] = prefix[i] * nums[i];
            suffix[n - i - 1] = suffix[n - i - 1] * nums[n - i - 1];
        }
        for i in 1..n {
            prefix[i] = gcd(prefix[i], prefix[i - 1]);
            suffix[n - i - 1] = gcd(suffix[n - i - 1], suffix[n - i]);
        }
        for i in 0..n {
            if (i == 0 || prefix[i - 1] == 1) && (i == n - 1 || suffix[i + 1] == 1) {
                return i as i32;
            }
        }
        -1
    }
}
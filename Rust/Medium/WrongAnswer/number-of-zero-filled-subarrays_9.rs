impl Solution {
    pub fn zero_filled_subarray(nums: Vec<i32>) -> i64 {
        
        let n = nums.len();
        let mut sum = 0;
        let mut ans = 0;
        let mut sum_to_index = std::collections::HashMap::new();
        for i in 0..n {
            sum += nums[i];
            if sum == 0 {
                ans += i as i64 + 1;
            }
            if let Some(&j) = sum_to_index.get(&sum) {
                ans += (i - j) as i64;
            }
            sum_to_index.insert(sum, i);
        }
        ans
    }
}
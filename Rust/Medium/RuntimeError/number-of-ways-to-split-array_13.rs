impl Solution {
    pub fn ways_to_split_array(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut prefix_sum = vec![0; nums.len()];
        let mut suffix_sum = vec![0; nums.len()];
        for i in 0..nums.len() {
            sum += nums[i];
            prefix_sum[i] = sum;
        }
        sum = 0;
        for i in (0..nums.len()).rev() {
            sum += nums[i];
            suffix_sum[i] = sum;
        }
        let mut ans = 0;
        let mut i = 0;
        for j in 0..nums.len() - 1 {
            while i < j && prefix_sum[i] <= suffix_sum[j] {
                i += 1;
            }
            let k = j + 1;
            if i <= k && prefix_sum[i - 1] <= suffix_sum[k] && prefix_sum[k - 1] - prefix_sum[i - 1] >= suffix_sum[k] - suffix_sum[j] {
                ans += 1;
            }
        }
        ans as i32
    }
}
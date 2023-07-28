impl Solution {
    pub fn max_sum_min_product(nums: Vec<i32>) -> i32 {
        
        let mut stack = Vec::new();
        let mut left = vec![0; nums.len()];
        let mut right = vec![nums.len(); nums.len()];
        for i in 0..nums.len() {
            while let Some(&j) = stack.last() {
                if nums[j] < nums[i] {
                    break;
                }
                right[j] = i;
                stack.pop();
            }
            if let Some(&j) = stack.last() {
                left[i] = j + 1;
            }
            stack.push(i);
        }
        let mut prefix = vec![0; nums.len() + 1];
        for i in 0..nums.len() {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        let mut ans = 0;
        for i in 0..nums.len() {
            ans = std::cmp::max(ans, nums[i] * (prefix[right[i]] - prefix[left[i]]));
        }
        (ans % 1000000007) as i32
    }
}
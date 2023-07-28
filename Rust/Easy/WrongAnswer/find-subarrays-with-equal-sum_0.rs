impl Solution {
    pub fn find_subarrays(nums: Vec<i32>) -> bool {
        
        let n = nums.len();
        let mut sum = vec![0; n + 1];
        for i in 0..n {
            sum[i + 1] = sum[i] + nums[i];
        }
        for i in 0..n {
            for j in i + 2..n + 1 {
                if sum[j] - sum[i] == sum[i + 1] - sum[0] {
                    return true;
                }
            }
        }
        false
    }
}
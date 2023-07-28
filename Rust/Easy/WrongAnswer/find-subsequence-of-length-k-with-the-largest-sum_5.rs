impl Solution {
    pub fn max_subsequence(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut res = vec![0; k as usize];
        let mut i = 0;
        let mut j = 0;
        let mut sum = 0;
        let mut max_sum = 0;
        let mut max_i = 0;
        let mut max_j = 0;
        while i < nums.len() {
            sum += nums[i];
            if i >= k as usize {
                sum -= nums[j];
                j += 1;
            }
            if i >= k as usize - 1 && sum > max_sum {
                max_sum = sum;
                max_i = i;
                max_j = j;
            }
            i += 1;
        }
        for i in max_j..=max_i {
            res[i - max_j] = nums[i];
        }
        res
    }
}
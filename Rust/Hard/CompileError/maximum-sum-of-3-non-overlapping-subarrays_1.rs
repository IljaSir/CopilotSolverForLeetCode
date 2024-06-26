impl Solution {
    pub fn max_sum_of_three_subarrays(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let k = k as usize;
        let mut sum = vec![0; nums.len() + 1];
        for i in 0..nums.len() {
            sum[i+1] = sum[i] + nums[i];
        }
        let mut left = vec![0; nums.len()];
        let mut right = vec![0; nums.len()];
        for i in k..nums.len() {
            if sum[i+1] - sum[i+1-k] > sum[left[i-1]+1] - sum[left[i-1]+1-k] {
                left[i] = i + 1 - k;
            } else {
                left[i] = left[i-1];
            }
        }
        right[nums.len()-k] = nums.len() - k;
        for i in (0..nums.len()-k).rev() {
            if sum[i+k] - sum[i] >= sum[right[i+1]+k] - sum[right[i+1]] {
                right[i] = i;
            } else {
                right[i] = right[i+1];
            }
        }
        let mut ans = vec![0, 0, 0];
        for i in k..nums.len()-k {
            let l = left[i-1];
            let r = right[i+k];
            if sum[l+k] - sum[l] + sum[i+k] - sum[i] + sum[r+k] - sum[r] > sum[ans[0]+k] - sum[ans[0]] + sum[ans[1]+k] - sum[ans[1]] + sum[ans[2]+k] - sum[ans[2]] {
                ans = vec![l, i, r];
            }
        }
        ans
    }
}
impl Solution {
    pub fn maximum_segment_sum(nums: Vec<i32>, remove_queries: Vec<i32>) -> Vec<i64> {
        
        let n = nums.len();
        let mut seg = vec![0; n + 1];
        let mut seg_sum = vec![0; n + 1];
        let mut ans = vec![0; n];
        let mut max_sum = 0;
        let mut max_seg = 0;
        let mut max_seg_sum = 0;
        for i in 0..n {
            seg[i] = 1;
            seg_sum[i] = nums[i] as i64;
            max_sum += nums[i] as i64;
            max_seg = i as i64;
            max_seg_sum = max_sum;
            ans[i] = max_seg_sum;
        }
        for i in (0..n).rev() {
            let idx = remove_queries[i] as usize;
            max_sum -= nums[idx] as i64;
            let left = if idx == 0 { 0 } else { seg_sum[idx - 1] };
            let right = if idx == n - 1 { 0 } else { seg_sum[n - 1] - seg_sum[idx] };
            let sum = left + right;
            if sum > max_seg_sum {
                max_seg_sum = sum;
                max_seg = max_seg - seg[idx] + 1;
            }
            seg_sum[idx] = left + right;
            seg[idx] = 0;
            ans[i] = max_seg_sum + max_seg;
        }
        ans
    }
}
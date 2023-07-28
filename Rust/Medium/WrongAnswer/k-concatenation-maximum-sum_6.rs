impl Solution {
    pub fn k_concatenation_max_sum(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = 0;
        let mut max_sum = 0;
        let mut min_sum = 0;
        let mut total_sum = 0;
        let mut max = 0;
        for i in 0..arr.len() {
            if i < k as usize {
                total_sum += arr[i];
            }
            sum += arr[i];
            max_sum = max_sum.max(sum - min_sum);
            min_sum = min_sum.min(sum);
            max = max.max(sum);
        }
        if k == 1 {
            return max_sum as i32 % 1000000007;
        }
        if max <= 0 {
            return 0;
        }
        let mut ans = max_sum + (k - 2) * total_sum;
        if total_sum > 0 {
            ans += total_sum;
        }
        ans as i32 % 1000000007
    }
}
impl Solution {
    pub fn k_concatenation_max_sum(arr: Vec<i32>, k: i32) -> i32 {
        
        let n = arr.len();
        let mut prefix_sum = vec![0; n + 1];
        let mut suffix_sum = vec![0; n + 1];
        let mut sum = 0;
        for i in 0..n {
            sum += arr[i];
            prefix_sum[i + 1] = prefix_sum[i].max(sum);
        }
        sum = 0;
        for i in 0..n {
            sum += arr[n - 1 - i];
            suffix_sum[i + 1] = suffix_sum[i].max(sum);
        }
        let mut ans = 0;
        for i in 0..n {
            ans = ans.max(prefix_sum[i] + suffix_sum[n - i]);
        }
        if k > 1 {
            let mut sum = 0;
            for i in 0..n {
                sum += arr[i];
            }
            if sum > 0 {
                ans = ans.max(prefix_sum[n] + suffix_sum[n] + (k - 2) * sum);
            }
        }
        (ans % 1000000007) as i32
    }
}
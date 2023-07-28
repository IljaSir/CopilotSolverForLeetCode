impl Solution {
    pub fn min_operations(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i64> {
        
        let mut freq = vec![0; 100001];
        let mut sum = vec![0; 100001];
        let mut res = vec![0; queries.len()];
        let mut j = 0;
        for i in nums {
            freq[i as usize] += 1;
        }
        for i in 1..freq.len() {
            sum[i] = sum[i - 1] + freq[i];
        }
        for i in queries {
            while j < sum.len() && sum[j] <= i {
                j += 1;
            }
            let mut tmp = 0;
            for k in j..sum.len() {
                tmp += (k as i64 - j as i64) * (sum[k] - sum[j - 1]);
            }
            res.push(tmp);
        }
        res
    }
}
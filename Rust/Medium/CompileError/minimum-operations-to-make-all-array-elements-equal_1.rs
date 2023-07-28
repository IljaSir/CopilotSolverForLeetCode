impl Solution {
    pub fn min_operations(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i64> {
        
        let mut freq = vec![0; 100001];
        let mut prefix = vec![0; 100002];
        for &n in nums.iter() {
            freq[n as usize] += 1;
        }
        for i in 1..=100001 {
            prefix[i] = prefix[i-1] + freq[i];
        }
        let mut ans = Vec::new();
        for &q in queries.iter() {
            let mut sum = 0;
            for i in 1..=100001 {
                if i as i32 > q {
                    sum += (i as i32 - q) * (prefix[i] - prefix[i-1]);
                } else {
                    sum += (q - i as i32) * (prefix[i] - prefix[i-1]);
                }
            }
            ans.push(sum);
        }
        ans
    }
}
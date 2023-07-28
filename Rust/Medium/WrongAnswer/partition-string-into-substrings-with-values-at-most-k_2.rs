impl Solution {
    pub fn minimum_partition(s: String, k: i32) -> i32 {
        
        let mut ans = 0;
        let mut sum = 0;
        let mut max = 0;
        for c in s.chars() {
            let v = c as i32 - '0' as i32;
            sum += v;
            max = max.max(v);
            if sum - max > k {
                ans += 1;
                sum = v;
                max = v;
            }
        }
        ans + 1
    }
}
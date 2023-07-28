impl Solution {
    pub fn minimum_partition(s: String, k: i32) -> i32 {
        
        let mut ans = 0;
        let mut last = 0;
        let mut max = 0;
        for (i, c) in s.chars().enumerate() {
            let n = c.to_digit(10).unwrap() as i32;
            max = std::cmp::max(max, n);
            if max * (i - last + 1) > k {
                ans += 1;
                last = i;
                max = n;
            }
        }
        ans + 1
    }
}
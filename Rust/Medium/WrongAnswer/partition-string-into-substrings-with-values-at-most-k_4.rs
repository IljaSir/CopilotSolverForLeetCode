impl Solution {
    pub fn minimum_partition(s: String, k: i32) -> i32 {
        
        let mut ans = 0;
        let mut max = 0;
        let mut pre = 0;
        for c in s.chars() {
            let n = c.to_digit(10).unwrap() as i32;
            max = std::cmp::max(max, n);
            if max * (pre + 1) > k {
                ans += 1;
                pre = 0;
                max = n;
            } else {
                pre += 1;
            }
        }
        if pre > 0 {
            ans += 1;
        }
        ans
    }
}
impl Solution {
    pub fn minimum_partition(s: String, k: i32) -> i32 {
        
        let mut ans = 0;
        let mut cur = 0;
        let mut max = 0;
        for c in s.chars() {
            cur = cur * 10 + (c as i32 - '0' as i32);
            max = std::cmp::max(max, c as i32 - '0' as i32);
            if cur - max > k {
                ans += 1;
                cur = max;
            }
        }
        ans + 1
    }
}
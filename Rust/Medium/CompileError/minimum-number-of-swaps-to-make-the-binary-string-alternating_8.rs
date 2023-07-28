impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let mut ans = 0;
        let mut cnt = 0;
        for i in 0..s.len() {
            if s[i] == '0' {
                cnt += 1;
            } else {
                cnt -= 1;
            }
            if cnt.abs() > 1 {
                ans += 1;
                cnt = 0;
            }
        }
        if cnt.abs() != 1 {
            -1
        } else {
            ans
        }
    }
}
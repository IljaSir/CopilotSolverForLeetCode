impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let mut cnt = 0;
        let mut cnt2 = 0;
        for (i, c) in s.chars().enumerate() {
            if i % 2 == 0 {
                if c == '0' {
                    cnt += 1;
                } else {
                    cnt2 += 1;
                }
            } else {
                if c == '0' {
                    cnt2 += 1;
                } else {
                    cnt += 1;
                }
            }
        }
        if cnt == cnt2 {
            cnt.min(cnt2)
        } else {
            -1
        }
    }
}
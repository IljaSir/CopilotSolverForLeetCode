impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let mut ans1 = 0;
        let mut ans2 = 0;
        for (i, c) in s.chars().enumerate() {
            if i % 2 == 0 {
                if c == '0' {
                    ans1 += 1;
                } else {
                    ans2 += 1;
                }
            } else {
                if c == '0' {
                    ans2 += 1;
                } else {
                    ans1 += 1;
                }
            }
        }
        if ans1 % 2 == 1 {
            ans1 = std::i32::MAX;
        }
        if ans2 % 2 == 1 {
            ans2 = std::i32::MAX;
        }
        if ans1 == std::i32::MAX && ans2 == std::i32::MAX {
            -1
        } else {
            ans1.min(ans2) / 2
        }
    }
}
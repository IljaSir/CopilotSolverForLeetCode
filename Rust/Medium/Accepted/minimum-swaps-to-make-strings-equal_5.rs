impl Solution {
    pub fn minimum_swap(s1: String, s2: String) -> i32 {
        
        let mut x = 0;
        let mut y = 0;
        for (c1, c2) in s1.chars().zip(s2.chars()) {
            if c1 == c2 {
                continue;
            }
            if c1 == 'x' {
                x += 1;
            } else {
                y += 1;
            }
        }
        let mut ans = x / 2 + y / 2;
        if x % 2 == 1 && y % 2 == 1 {
            ans += 2;
        }
        if x % 2 == 1 && y % 2 == 0 || x % 2 == 0 && y % 2 == 1 {
            return -1;
        }
        ans
    }
}
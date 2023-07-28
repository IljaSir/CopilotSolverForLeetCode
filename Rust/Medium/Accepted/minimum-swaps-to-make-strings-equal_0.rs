impl Solution {
    pub fn minimum_swap(s1: String, s2: String) -> i32 {
        
        let (mut xy, mut yx) = (0, 0);
        for (c1, c2) in s1.chars().zip(s2.chars()) {
            if c1 == c2 {
                continue;
            }
            if c1 == 'x' {
                xy += 1;
            } else {
                yx += 1;
            }
        }
        let mut ans = xy / 2 + yx / 2;
        xy %= 2;
        yx %= 2;
        if (xy + yx) % 2 == 1 {
            return -1;
        }
        if xy == 1 {
            ans += 2;
        }
        ans
    }
}
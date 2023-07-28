impl Solution {
    pub fn minimum_swap(s1: String, s2: String) -> i32 {
        
        let mut res = 0;
        let mut xy = 0;
        let mut yx = 0;
        for i in 0..s1.len() {
            if s1.as_bytes()[i] != s2.as_bytes()[i] {
                if s1.as_bytes()[i] == 'x' as u8 {
                    xy += 1;
                } else {
                    yx += 1;
                }
            }
        }
        res += xy / 2 + yx / 2;
        xy %= 2;
        yx %= 2;
        if xy == 0 && yx == 0 {
            res
        } else if xy == 1 && yx == 1 {
            res + 2
        } else {
            -1
        }
    }
}
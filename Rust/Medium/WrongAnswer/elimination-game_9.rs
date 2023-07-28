impl Solution {
    pub fn last_remaining(n: i32) -> i32 {
        

        if n == 1 {
            return 1;
        }
        let mut s = 1;
        let mut e = n;
        let mut flag = true;
        let mut step = 1;
        while s < e {
            if flag {
                s += step;
            } else {
                e -= step;
            }
            flag = !flag;
            step *= 2;
        }
        s
    }
}
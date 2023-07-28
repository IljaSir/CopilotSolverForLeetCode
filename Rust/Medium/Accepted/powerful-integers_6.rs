impl Solution {
    pub fn powerful_integers(x: i32, y: i32, bound: i32) -> Vec<i32> {
        
        let mut res: Vec<i32> = vec![];
        let mut i = 0;
        let mut j = 0;
        let mut x_pow = 1;
        let mut y_pow = 1;
        while x_pow < bound {
            while y_pow < bound {
                let pow_sum = x_pow + y_pow;
                if pow_sum <= bound && !res.contains(&pow_sum) {
                    res.push(pow_sum);
                }
                if y == 1 {
                    break;
                }
                j += 1;
                y_pow = y.pow(j);
            }
            if x == 1 {
                break;
            }
            i += 1;
            j = 0;
            x_pow = x.pow(i);
            y_pow = y.pow(j);
        }
        res
    }
}
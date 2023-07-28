impl Solution {
    pub fn powerful_integers(x: i32, y: i32, bound: i32) -> Vec<i32> {
        
        let mut res = vec![];
        let mut i = 0;
        let mut j = 0;
        let mut a = 1;
        let mut b = 1;
        while a + b <= bound {
            while a + b <= bound {
                res.push(a + b);
                if y == 1 {
                    break;
                }
                b *= y;
                j += 1;
            }
            if x == 1 {
                break;
            }
            a *= x;
            i += 1;
            j = 0;
            b = 1;
        }
        res.sort();
        res.dedup();
        res
    }
}
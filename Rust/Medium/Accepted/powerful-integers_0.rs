impl Solution {
    pub fn powerful_integers(x: i32, y: i32, bound: i32) -> Vec<i32> {
        
        let mut ret = vec![];
        let mut i = 0;
        while x.pow(i) < bound {
            let mut j = 0;
            while x.pow(i) + y.pow(j) <= bound {
                ret.push(x.pow(i) + y.pow(j));
                if y == 1 {
                    break;
                }
                j += 1;
            }
            if x == 1 {
                break;
            }
            i += 1;
        }
        ret.sort();
        ret.dedup();
        ret
    }
}
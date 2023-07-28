impl Solution {
    pub fn powerful_integers(x: i32, y: i32, bound: i32) -> Vec<i32> {
        
        let mut res = vec![];
        let mut i = 0;
        let mut j = 0;
        loop {
            let mut tmp = i32::pow(x, i) + i32::pow(y, j);
            if tmp <= bound {
                if !res.contains(&tmp) {
                    res.push(tmp);
                }
            } else {
                if y == 1 {
                    break;
                }
                j = 0;
                i += 1;
                continue;
            }
            if x == 1 {
                break;
            }
            j += 1;
        }
        res
    }
}
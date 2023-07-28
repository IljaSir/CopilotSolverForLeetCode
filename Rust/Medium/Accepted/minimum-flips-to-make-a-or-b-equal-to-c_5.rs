impl Solution {
    pub fn min_flips(a: i32, b: i32, c: i32) -> i32 {
        
        let mut res = 0;
        for i in 0..32 {
            let mask = 1 << i;
            let x = a & mask;
            let y = b & mask;
            let z = c & mask;
            if z == 0 {
                if x != 0 {
                    res += 1;
                }
                if y != 0 {
                    res += 1;
                }
            } else {
                if x == 0 && y == 0 {
                    res += 1;
                }
            }
        }
        return res;
    }
}
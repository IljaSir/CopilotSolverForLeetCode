impl Solution {
    pub fn min_bit_flips(start: i32, goal: i32) -> i32 {
        
        let mut res = 0;
        let mut flip = 0;
        for i in 0..32 {
            let bit = (goal >> i) & 1;
            if bit == 0 {
                if (start >> i) & 1 == 0 {
                    if flip % 2 == 0 {
                        res += 1;
                        flip += 1;
                    }
                } else {
                    if flip % 2 == 1 {
                        res += 1;
                        flip += 1;
                    }
                }
            } else {
                if (start >> i) & 1 == 0 {
                    if flip % 2 == 1 {
                        res += 1;
                        flip += 1;
                    }
                } else {
                    if flip % 2 == 0 {
                        res += 1;
                        flip += 1;
                    }
                }
            }
        }
        res
    }
}
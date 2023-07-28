impl Solution {
    pub fn get_xor_sum(arr1: Vec<i32>, arr2: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for i in 0..32 {
            let mut c1 = 0;
            let mut c2 = 0;
            for &a in &arr1 {
                if a & (1 << i) != 0 {
                    c1 += 1;
                }
            }
            for &a in &arr2 {
                if a & (1 << i) != 0 {
                    c2 += 1;
                }
            }
            if (c1 % 2 == 1 && c2 % 2 == 1) || (c1 % 2 == 0 && c2 % 2 == 0) {
                continue;
            }
            res |= 1 << i;
        }
        res
    }
}
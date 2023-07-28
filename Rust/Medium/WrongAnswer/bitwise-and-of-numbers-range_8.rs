impl Solution {
    pub fn range_bitwise_and(left: i32, right: i32) -> i32 {
        

        let mut res = 0;
        for i in 0..32 {
            let mask = 1 << i;
            if (left & mask) == (right & mask) {
                res |= (left & mask);
            } else {
                break;
            }
        }
        res
    }
}
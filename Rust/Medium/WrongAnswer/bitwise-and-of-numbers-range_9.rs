impl Solution {
    pub fn range_bitwise_and(left: i32, right: i32) -> i32 {
        

        let mut n = 0;
        for i in 0..32 {
            if (left & (1 << i)) == (right & (1 << i)) {
                n |= (left & (1 << i));
            } else {
                break;
            }
        }
        n
    }
}
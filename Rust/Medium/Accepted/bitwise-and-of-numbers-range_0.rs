impl Solution {
    pub fn range_bitwise_and(left: i32, right: i32) -> i32 {
        

        let mut i = 0;
        let mut left = left;
        let mut right = right;
        while left != right {
            left >>= 1;
            right >>= 1;
            i += 1;
        }
        left << i
    }
}
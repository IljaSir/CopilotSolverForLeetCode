impl Solution {
    pub fn range_bitwise_and(left: i32, right: i32) -> i32 {
        

        let mut left = left;
        let mut right = right;
        let mut count = 0;
        while left != right {
            left >>= 1;
            right >>= 1;
            count += 1;
        }
        left <<= count;
        left
    }
}
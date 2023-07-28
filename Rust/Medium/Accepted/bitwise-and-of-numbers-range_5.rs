impl Solution {
    pub fn range_bitwise_and(left: i32, right: i32) -> i32 {
        

        if left == right {
            return left;
        }
        let mut l = left;
        let mut r = right;
        let mut count = 0;
        while l != r {
            l >>= 1;
            r >>= 1;
            count += 1;
        }
        l <<= count;
        l
    }
}
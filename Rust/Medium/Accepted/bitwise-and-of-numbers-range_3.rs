impl Solution {
    pub fn range_bitwise_and(left: i32, right: i32) -> i32 {
        

        let mut l = left;
        let mut r = right;
        let mut i = 0;
        while l != r {
            l >>= 1;
            r >>= 1;
            i += 1;
        }
        l << i
    }
}
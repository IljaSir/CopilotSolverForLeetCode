impl Solution {
    pub fn range_bitwise_and(left: i32, right: i32) -> i32 {
        

        let mut ans = 0;
        let mut l = left;
        let mut r = right;
        let mut i = 0;
        while l != 0 && r != 0 {
            if l == r {
                ans += (l & 1) << i;
            }
            l >>= 1;
            r >>= 1;
            i += 1;
        }
        ans
    }
}
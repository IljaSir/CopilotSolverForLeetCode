impl Solution {
    pub fn binary_gap(n: i32) -> i32 {
        
        let mut n = n;
        let mut last = -1;
        let mut ans = 0;
        for i in 0..32 {
            if (n & 1) != 0 {
                if last >= 0 {
                    ans = ans.max(i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        ans
    }
}
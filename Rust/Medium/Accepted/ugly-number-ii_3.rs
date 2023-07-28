impl Solution {
    pub fn nth_ugly_number(n: i32) -> i32 {
        

        let mut ugly = vec![1; n as usize];
        let mut i2 = 0;
        let mut i3 = 0;
        let mut i5 = 0;
        let mut next2 = 2;
        let mut next3 = 3;
        let mut next5 = 5;
        for i in 1..n as usize {
            let next = next2.min(next3.min(next5));
            ugly[i] = next;
            if next == next2 {
                i2 += 1;
                next2 = ugly[i2] * 2;
            }
            if next == next3 {
                i3 += 1;
                next3 = ugly[i3] * 3;
            }
            if next == next5 {
                i5 += 1;
                next5 = ugly[i5] * 5;
            }
        }
        ugly[(n - 1) as usize]
    }
}
impl Solution {
    pub fn nth_ugly_number(n: i32) -> i32 {
        

        let mut ugly = vec![1];
        let mut i2 = 0;
        let mut i3 = 0;
        let mut i5 = 0;
        while ugly.len() < n as usize {
            let u2 = ugly[i2] * 2;
            let u3 = ugly[i3] * 3;
            let u5 = ugly[i5] * 5;
            let min = u2.min(u3.min(u5));
            if min == u2 {
                i2 += 1;
            }
            if min == u3 {
                i3 += 1;
            }
            if min == u5 {
                i5 += 1;
            }
            ugly.push(min);
        }
        ugly[n as usize - 1]
    }
}
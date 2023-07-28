impl Solution {
    pub fn nth_ugly_number(n: i32) -> i32 {
        

        let mut ugly = vec![1];
        let mut i2 = 0;
        let mut i3 = 0;
        let mut i5 = 0;
        for _ in 0..n {
            let n2 = ugly[i2] * 2;
            let n3 = ugly[i3] * 3;
            let n5 = ugly[i5] * 5;
            let min = n2.min(n3.min(n5));
            if min == n2 {
                i2 += 1;
            }
            if min == n3 {
                i3 += 1;
            }
            if min == n5 {
                i5 += 1;
            }
            ugly.push(min);
        }
        ugly[n as usize - 1]
    }
}
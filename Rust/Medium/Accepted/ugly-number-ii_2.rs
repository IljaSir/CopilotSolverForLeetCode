impl Solution {
    pub fn nth_ugly_number(n: i32) -> i32 {
        

        let mut ugly = vec![1];
        let mut i2 = 0;
        let mut i3 = 0;
        let mut i5 = 0;
        let mut n2 = 2;
        let mut n3 = 3;
        let mut n5 = 5;

        while ugly.len() < n as usize {
            let min = n2.min(n3.min(n5));
            ugly.push(min);
            if min == n2 {
                i2 += 1;
                n2 = ugly[i2] * 2;
            }
            if min == n3 {
                i3 += 1;
                n3 = ugly[i3] * 3;
            }
            if min == n5 {
                i5 += 1;
                n5 = ugly[i5] * 5;
            }
        }
        ugly[n as usize - 1]
    }
}
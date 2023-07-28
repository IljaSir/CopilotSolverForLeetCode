impl Solution {
    pub fn nth_ugly_number(n: i32) -> i32 {
        

        let mut ugly = vec![1];
        let mut i2 = 0;
        let mut i3 = 0;
        let mut i5 = 0;
        while ugly.len() < n as usize {
            let next2 = ugly[i2] * 2;
            let next3 = ugly[i3] * 3;
            let next5 = ugly[i5] * 5;
            let next = next2.min(next3.min(next5));
            if next == next2 {
                i2 += 1;
            }
            if next == next3 {
                i3 += 1;
            }
            if next == next5 {
                i5 += 1;
            }
            ugly.push(next);
        }
        ugly[n as usize - 1]
    }
}
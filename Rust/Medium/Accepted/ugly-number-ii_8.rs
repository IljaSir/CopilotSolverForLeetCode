impl Solution {
    pub fn nth_ugly_number(n: i32) -> i32 {
        

        let mut ugly = vec![1];
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        for _ in 1..n {
            let mut next = ugly[i] * 2;
            if next > ugly[j] * 3 {
                next = ugly[j] * 3;
            }
            if next > ugly[k] * 5 {
                next = ugly[k] * 5;
            }
            if next == ugly[i] * 2 {
                i += 1;
            }
            if next == ugly[j] * 3 {
                j += 1;
            }
            if next == ugly[k] * 5 {
                k += 1;
            }
            ugly.push(next);
        }
        ugly[n as usize - 1]
    }
}
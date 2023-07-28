impl Solution {
    pub fn nth_ugly_number(n: i32) -> i32 {
        

        let mut ugly = vec![1];
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        for _ in 1..n {
            let mut min = ugly[i] * 2;
            if min > ugly[j] * 3 {
                min = ugly[j] * 3;
            }
            if min > ugly[k] * 5 {
                min = ugly[k] * 5;
            }
            if min == ugly[i] * 2 {
                i += 1;
            }
            if min == ugly[j] * 3 {
                j += 1;
            }
            if min == ugly[k] * 5 {
                k += 1;
            }
            ugly.push(min);
        }
        ugly[n as usize - 1]
    }
}
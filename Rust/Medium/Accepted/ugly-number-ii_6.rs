impl Solution {
    pub fn nth_ugly_number(n: i32) -> i32 {
        

        let mut ugly = vec![1];
        let mut idx2 = 0;
        let mut idx3 = 0;
        let mut idx5 = 0;
        let mut i = 1;
        while i < n {
            let next = ugly[idx2] * 2;
            let next = if next < ugly[idx3] * 3 { next } else { ugly[idx3] * 3 };
            let next = if next < ugly[idx5] * 5 { next } else { ugly[idx5] * 5 };
            ugly.push(next);
            if next == ugly[idx2] * 2 {
                idx2 += 1;
            }
            if next == ugly[idx3] * 3 {
                idx3 += 1;
            }
            if next == ugly[idx5] * 5 {
                idx5 += 1;
            }
            i += 1;
        }
        ugly[n as usize - 1]
    }
}
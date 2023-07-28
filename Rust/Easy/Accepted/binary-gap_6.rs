impl Solution {
    pub fn binary_gap(n: i32) -> i32 {
        
        let mut n = n;
        let mut max = 0;
        let mut count = 0;
        let mut flag = false;
        while n > 0 {
            if n & 1 == 1 {
                if flag {
                    if count > max {
                        max = count;
                    }
                    count = 1;
                } else {
                    flag = true;
                    count = 1;
                }
            } else if flag {
                count += 1;
            }
            n >>= 1;
        }
        max
    }
}
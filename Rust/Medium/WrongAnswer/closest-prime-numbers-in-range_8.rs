impl Solution {
    pub fn closest_primes(left: i32, right: i32) -> Vec<i32> {
        
        let mut ans = vec![-1,-1];
        let mut min_gap = 1000000;
        let mut i = left;
        while i <= right {
            if i > 2 && i % 2 == 0 {
                i += 1;
                continue;
            }
            let mut j = 3;
            while j*j <= i {
                if i % j == 0 {
                    break;
                }
                j += 2;
            }
            if j*j > i {
                if i - ans[0] < min_gap {
                    ans[1] = i;
                    min_gap = i - ans[0];
                }
                ans[0] = i;
            }
            i += 1;
        }
        ans
    }
}
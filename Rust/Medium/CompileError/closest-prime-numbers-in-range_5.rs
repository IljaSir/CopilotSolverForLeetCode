impl Solution {
    pub fn closest_primes(left: i32, right: i32) -> Vec<i32> {
        
        let mut ans = vec![-1, -1];
        let mut min_gap = right - left;
        for i in left..=right {
            if !is_prime(i) {
                continue;
            }
            if i - 1 > left && is_prime(i - 1) {
                let gap = i - (i - 1);
                if gap < min_gap {
                    ans[0] = i - 1;
                    ans[1] = i;
                    min_gap = gap;
                }
            }
            if i + 1 < right && is_prime(i + 1) {
                let gap = (i + 1) - i;
                if gap < min_gap {
                    ans[0] = i;
                    ans[1] = i + 1;
                    min_gap = gap;
                }
            }
        }
        ans
    }
}
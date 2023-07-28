impl Solution {
    pub fn closest_primes(left: i32, right: i32) -> Vec<i32> {
        
        let mut ans: Vec<i32> = vec![-1, -1];
        let mut min_gap = right - left;
        for i in left..=right {
            if Self::is_prime(i) {
                if ans[0] == -1 {
                    ans[0] = i;
                } else if ans[1] == -1 {
                    ans[1] = i;
                    if ans[1] - ans[0] < min_gap {
                        min_gap = ans[1] - ans[0];
                    }
                } else {
                    ans[0] = ans[1];
                    ans[1] = i;
                    if ans[1] - ans[0] < min_gap {
                        min_gap = ans[1] - ans[0];
                    }
                }
            }
        }
        ans
    }
    
    fn is_prime(num: i32) -> bool {
        if num <= 1 {
            return false;
        }
        for i in 2..num {
            if num % i == 0 {
                return false;
            }
        }
        true
    }
}
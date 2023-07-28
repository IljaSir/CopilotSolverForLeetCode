impl Solution {
    pub fn find_min_fibonacci_numbers(k: i32) -> i32 {
        
        let mut res = 0;
        let mut a = 1;
        let mut b = 1;
        while b <= k {
            res += k / b;
            let tmp = a;
            a = b;
            b = tmp + b;
        }
        res
    }
}
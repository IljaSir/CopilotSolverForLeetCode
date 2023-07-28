impl Solution {
    pub fn check_perfect_number(num: i32) -> bool {
        
        if num == 1 { return false; }
        let mut sum = 1;
        let mut i = 2;
        let mut n = num;
        while i * i <= n {
            if n % i == 0 {
                sum += i;
                if i * i != n {
                    sum += n / i;
                }
            }
            i += 1;
        }
        sum == num
    }
}
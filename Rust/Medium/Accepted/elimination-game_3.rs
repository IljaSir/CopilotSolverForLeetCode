impl Solution {
    pub fn last_remaining(n: i32) -> i32 {
        

        let mut n = n;
        let mut left = true;
        let mut step = 1;
        let mut head = 1;
        while n > 1 {
            if left || n % 2 == 1 {
                head += step;
            }
            n /= 2;
            step *= 2;
            left = !left;
        }
        head
    }
}
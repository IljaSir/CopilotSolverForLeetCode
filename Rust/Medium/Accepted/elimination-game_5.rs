impl Solution {
    pub fn last_remaining(n: i32) -> i32 {
        

        let mut n = n;
        let mut head = 1;
        let mut step = 1;
        let mut remaining = true;
        while n > 1 {
            if remaining {
                head += step;
            } else {
                if n % 2 == 1 {
                    head += step;
                }
            }
            step *= 2;
            n /= 2;
            remaining = !remaining;
        }
        head
    }
}
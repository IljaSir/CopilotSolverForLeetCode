impl Solution {
    pub fn climb_stairs(n: i32) -> i32 {
        
        if n == 1 {
            return 1;
        }
        if n == 2 {
            return 2;
        }
        let mut prev = 1;
        let mut curr = 2;
        for _ in 2..n {
            let tmp = curr;
            curr = curr + prev;
            prev = tmp;
        }
        curr
    }
}
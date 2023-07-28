impl Solution {
    pub fn pass_the_pillow(n: i32, time: i32) -> i32 {
        
        let mut res = 1;
        let mut i = 0;
        while i < time {
            if res == n {
                res -= 1;
            } else if res == 1 {
                res += 1;
            } else {
                res += if i % 2 == 0 { 1 } else { -1 };
            }
            i += 1;
        }
        res
    }
}
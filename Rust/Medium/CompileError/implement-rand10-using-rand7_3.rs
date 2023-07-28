impl Solution {
    pub fn rand10() -> i32 {
        
        loop {
            let x = rand7();
            let y = rand7();
            let res = x + (y - 1) * 7;
            if res <= 40 {
                return res % 10 + 1;
            }
        }
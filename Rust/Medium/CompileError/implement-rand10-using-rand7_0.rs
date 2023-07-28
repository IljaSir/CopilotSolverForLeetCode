impl Solution {
    pub fn rand10() -> i32 {
        
        loop {
            let x = rand7();
            let y = rand7();
            let idx = x + (y - 1) * 7;
            if idx <= 40 {
                return 1 + (idx - 1) % 10;
            }
        }
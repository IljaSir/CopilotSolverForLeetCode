impl Solution {
    pub fn rand10() -> i32 {
        
        let mut x = 0;
        let mut y = 0;
        let mut idx = 0;
        while idx == 0 {
            x = rand7();
            y = rand7();
            idx = (x - 1) * 7 + y;
        }
        return 1 + (idx - 1) % 10;
    }
}
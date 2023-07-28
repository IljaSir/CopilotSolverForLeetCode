impl Solution {
    pub fn rand10() -> i32 {
        
        let mut r = 40;
        while r >= 40 {
            r = (rand7() - 1) * 7 + (rand7() - 1);
        }
        r % 10 + 1
    }
}
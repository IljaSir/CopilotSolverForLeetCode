impl Solution {
    pub fn rand10() -> i32 {
        
        let mut a = 0;
        let mut b = 0;
        let mut idx = 0;
        while idx == 0 {
            a = rand7();
            b = rand7();
            idx = (a-1) * 7 + b;
        }
        return (idx - 1) % 10 + 1;
    }
}
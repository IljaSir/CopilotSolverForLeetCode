impl Solution {
    pub fn minimum_sum(num: i32) -> i32 {
        
        let mut num = num;
        let mut a = 0;
        let mut b = 0;
        let mut i = 0;
        while num > 0 {
            let r = num % 10;
            num = num / 10;
            if i % 2 == 0 {
                a = a * 10 + r;
            } else {
                b = b * 10 + r;
            }
            i += 1;
        }
        a + b
    }
}
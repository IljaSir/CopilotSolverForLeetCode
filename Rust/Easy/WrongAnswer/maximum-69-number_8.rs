impl Solution {
    pub fn maximum69_number (num: i32) -> i32 {
        
        let mut num = num;
        let mut max = num;
        let mut i = 1;
        while num > 0 {
            let n = (num % 10).abs();
            if n == 6 {
                let mut new = num + i * 3;
                if new > max {
                    max = new;
                }
            }
            num = num / 10;
            i = i * 10;
        }
        max
    }
}
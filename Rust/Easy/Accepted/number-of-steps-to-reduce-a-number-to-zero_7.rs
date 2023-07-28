impl Solution {
    pub fn number_of_steps(num: i32) -> i32 {
        
        let mut num = num;
        let mut cnt = 0;
        while num > 0 {
            if num % 2 == 0 {
                num /= 2;
            } else {
                num -= 1;
            }
            cnt += 1;
        }
        cnt
    }
}
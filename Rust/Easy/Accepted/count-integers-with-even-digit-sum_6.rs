impl Solution {
    pub fn count_even(num: i32) -> i32 {
        
        let mut count = 0;
        for i in 1..=num {
            let mut sum = 0;
            let mut tmp = i;
            while tmp > 0 {
                sum += tmp % 10;
                tmp /= 10;
            }
            if sum % 2 == 0 {
                count += 1;
            }
        }
        count
    }
}
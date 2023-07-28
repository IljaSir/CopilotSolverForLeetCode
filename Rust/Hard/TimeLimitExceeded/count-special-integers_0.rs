impl Solution {
    pub fn count_special_numbers(n: i32) -> i32 {
        
        let mut count = 0;
        for i in 1..=n {
            if Self::is_special(i) {
                count += 1;
            }
        }
        count
    }
    
    fn is_special(n: i32) -> bool {
        let mut digits: Vec<u32> = Vec::new();
        let mut n = n;
        while n > 0 {
            let digit = (n % 10) as u32;
            if digits.contains(&digit) {
                return false;
            }
            digits.push(digit);
            n /= 10;
        }
        true
    }
}
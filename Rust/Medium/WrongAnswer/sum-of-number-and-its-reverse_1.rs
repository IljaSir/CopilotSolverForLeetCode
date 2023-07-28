impl Solution {
    pub fn sum_of_number_and_reverse(num: i32) -> bool {
        
        let mut n = num;
        let mut rev = 0;
        while n > 0 {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        (num + rev).to_string().chars().all(|x| x != '0')
    }
}
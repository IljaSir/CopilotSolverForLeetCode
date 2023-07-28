impl Solution {
    pub fn monotone_increasing_digits(n: i32) -> i32 {
        
        let mut digits: Vec<u8> = n.to_string().into_bytes();
        let mut i = 1;
        while i < digits.len() && digits[i - 1] <= digits[i] {
            i += 1;
        }
        while i > 0 && i < digits.len() && digits[i - 1] > digits[i] {
            digits[i - 1] -= 1;
            i -= 1;
        }
        for i in i + 1..digits.len() {
            digits[i] = b'9';
        }
        std::str::from_utf8(&digits).unwrap().parse().unwrap()
    }
}
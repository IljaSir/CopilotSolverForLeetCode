impl Solution {
    pub fn divisor_substrings(num: i32, k: i32) -> i32 {
        
        let num_s = num.to_string();
        let mut count = 0;
        for i in 0..(num_s.len() - k as usize + 1) {
            let s = &num_s[i..i + k as usize];
            let n = s.parse::<i32>().unwrap();
            if n != 0 && num % n == 0 {
                count += 1;
            }
        }
        count
    }
}
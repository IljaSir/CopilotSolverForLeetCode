impl Solution {
    pub fn digit_count(num: String) -> bool {
        
        let mut count = vec![0; 10];
        for c in num.chars() {
            let c = c as u8;
            count[(c - '0' as u8) as usize] += 1;
        }
        for i in 0..10 {
            let c = i as u8 + '0' as u8;
            if count[i] != 0 && count[i] != (c as char).to_digit(10).unwrap() as usize {
                return false;
            }
        }
        true
    }
}
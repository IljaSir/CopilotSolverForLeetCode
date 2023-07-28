impl Solution {
    pub fn largest_good_integer(num: String) -> String {
        
        let mut count = [0; 10];
        for c in num.as_bytes() {
            count[(c - b'0') as usize] += 1;
        }
        let mut max = 0;
        for i in 1..=9 {
            if count[i] >= 3 {
                max = i;
            }
        }
        if max == 0 {
            return String::new();
        }
        let mut result = String::new();
        for _ in 0..count[max] {
            result.push((max as u8 + b'0') as char);
        }
        result
    }
}
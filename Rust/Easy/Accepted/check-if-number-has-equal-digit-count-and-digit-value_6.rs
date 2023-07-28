impl Solution {
    pub fn digit_count(num: String) -> bool {
        
        let mut v: Vec<i32> = vec![0; 10];
        for c in num.chars() {
            v[c as usize - '0' as usize] += 1;
        }
        for i in 0..num.len() {
            if v[i] != (num.chars().nth(i).unwrap() as i32 - '0' as i32) {
                return false;
            }
        }
        true
    }
}
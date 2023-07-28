impl Solution {
    pub fn longest_palindrome(s: String) -> i32 {
        
        let mut count = 0;
        let mut table = [0; 128];
        for c in s.chars() {
            table[c as usize] += 1;
        }
        for i in 0..table.len() {
            count += table[i] / 2 * 2;
            if count % 2 == 0 && table[i] % 2 == 1 {
                count += 1;
            }
        }
        count
    }
}
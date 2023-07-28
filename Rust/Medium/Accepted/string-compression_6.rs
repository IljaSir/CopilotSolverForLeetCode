impl Solution {
    pub fn compress(chars: &mut Vec<char>) -> i32 {
        

        let mut i = 0;
        let mut j = 0;
        let mut count = 0;
        while i < chars.len() {
            chars[j] = chars[i];
            count = 0;
            while i < chars.len() && chars[i] == chars[j] {
                count += 1;
                i += 1;
            }
            j += 1;
            if count > 1 {
                for c in count.to_string().chars() {
                    chars[j] = c;
                    j += 1;
                }
            }
        }
        j as i32
    }
}
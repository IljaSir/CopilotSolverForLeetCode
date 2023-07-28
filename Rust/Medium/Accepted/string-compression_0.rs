impl Solution {
    pub fn compress(chars: &mut Vec<char>) -> i32 {
        

        let mut i = 0;
        let mut j = 0;
        while i < chars.len() {
            let mut count = 1;
            while i + 1 < chars.len() && chars[i] == chars[i + 1] {
                count += 1;
                i += 1;
            }
            chars[j] = chars[i];
            j += 1;
            if count > 1 {
                for c in count.to_string().chars() {
                    chars[j] = c;
                    j += 1;
                }
            }
            i += 1;
        }
        j as i32
    }
}
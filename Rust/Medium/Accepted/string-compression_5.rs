impl Solution {
    pub fn compress(chars: &mut Vec<char>) -> i32 {
        

        let mut i = 0;
        let mut j = 0;
        let mut count = 1;
        while j < chars.len() {
            while j + 1 < chars.len() && chars[j] == chars[j + 1] {
                count += 1;
                j += 1;
            }
            chars[i] = chars[j];
            i += 1;
            if count > 1 {
                for c in count.to_string().chars() {
                    chars[i] = c;
                    i += 1;
                }
            }
            count = 1;
            j += 1;
        }
        i as i32
    }
}
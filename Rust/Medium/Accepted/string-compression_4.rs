impl Solution {
    pub fn compress(chars: &mut Vec<char>) -> i32 {
        

        let mut i = 0;
        let mut j = 0;
        let mut count = 1;
        while i < chars.len() {
            if i + 1 < chars.len() && chars[i] == chars[i + 1] {
                count += 1;
            } else {
                chars[j] = chars[i];
                j += 1;
                if count > 1 {
                    let mut count_str = count.to_string();
                    for c in count_str.chars() {
                        chars[j] = c;
                        j += 1;
                    }
                }
                count = 1;
            }
            i += 1;
        }
        j as i32
    }
}
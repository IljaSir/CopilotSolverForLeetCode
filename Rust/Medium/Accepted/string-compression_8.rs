impl Solution {
    pub fn compress(chars: &mut Vec<char>) -> i32 {
        

        let mut i = 0;
        let mut j = 1;
        let mut count = 1;
        let mut new_length = 0;
        while j < chars.len() {
            if chars[i] == chars[j] {
                count += 1;
                j += 1;
            } else {
                chars[new_length] = chars[i];
                new_length += 1;
                if count > 1 {
                    for c in count.to_string().chars() {
                        chars[new_length] = c;
                        new_length += 1;
                    }
                }
                i = j;
                j += 1;
                count = 1;
            }
        }
        chars[new_length] = chars[i];
        new_length += 1;
        if count > 1 {
            for c in count.to_string().chars() {
                chars[new_length] = c;
                new_length += 1;
            }
        }
        new_length as i32
    }
}
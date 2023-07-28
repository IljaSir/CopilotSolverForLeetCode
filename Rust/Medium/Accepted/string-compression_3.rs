impl Solution {
    pub fn compress(chars: &mut Vec<char>) -> i32 {
        

        let mut i = 0;
        let mut j = 0;
        let mut count = 1;
        while j < chars.len() {
            if j == chars.len() - 1 || chars[j] != chars[j + 1] {
                chars[i] = chars[j];
                i += 1;
                if count > 1 {
                    let mut num = count.to_string();
                    for c in num.chars() {
                        chars[i] = c;
                        i += 1;
                    }
                }
                count = 1;
            } else {
                count += 1;
            }
            j += 1;
        }
        i as i32
    }
}
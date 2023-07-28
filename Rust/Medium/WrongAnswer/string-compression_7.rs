impl Solution {
    pub fn compress(chars: &mut Vec<char>) -> i32 {
        

        let mut i = 0;
        let mut j = 0;
        let mut n = chars.len();
        while i < n {
            let mut count = 1;
            while i + 1 < n && chars[i] == chars[i + 1] {
                count += 1;
                i += 1;
            }
            chars[j] = chars[i];
            j += 1;
            if count > 1 {
                let mut k = 0;
                let mut t = count;
                while t > 0 {
                    t /= 10;
                    k += 1;
                }
                let mut start = j + k - 1;
                t = count;
                while t > 0 {
                    chars[start] = (t % 10 + b'0') as char;
                    t /= 10;
                    start -= 1;
                }
                j += k;
            }
            i += 1;
        }
        j as i32
    }
}
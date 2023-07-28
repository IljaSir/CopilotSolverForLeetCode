impl Solution {
    pub fn compress(chars: &mut Vec<char>) -> i32 {
        

        let mut l = 0;
        let mut r = 0;
        let mut c = 0;
        let mut n = chars.len();
        while r < n {
            if chars[l] == chars[r] {
                c += 1;
                r += 1;
            } else {
                if c > 1 {
                    let mut num = c.to_string();
                    let mut num_len = num.len();
                    chars[l + 1..=l + num_len].copy_from_slice(&num.chars().collect::<Vec<char>>());
                    l += num_len;
                    n -= c - 1;
                }
                l += 1;
                chars[l] = chars[r];
                c = 0;
            }
        }
        if c > 1 {
            let mut num = c.to_string();
            let mut num_len = num.len();
            chars[l + 1..=l + num_len].copy_from_slice(&num.chars().collect::<Vec<char>>());
            l += num_len;
            n -= c - 1;
        }
        l as i32 + 1
    }
}
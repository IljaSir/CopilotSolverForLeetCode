impl Solution {
    pub fn longest_palindrome(words: Vec<String>) -> i32 {
        
        let mut res = 0;
        let mut odd = 0;
        let mut cnt = vec![0; 26];
        for w in words {
            let mut mask = 0;
            for c in w.chars() {
                mask ^= 1 << (c as u8 - b'a');
            }
            if mask == 0 {
                odd = 1;
            } else {
                for i in 0..26 {
                    if (mask & (1 << i)) != 0 && cnt[i] != 0 {
                        res += 2;
                        cnt[i] = 0;
                        mask = 0;
                        break;
                    }
                }
                if mask != 0 {
                    for i in 0..26 {
                        if (mask & (1 << i)) != 0 {
                            cnt[i] += 1;
                        }
                    }
                }
            }
        }
        res + odd
    }
}
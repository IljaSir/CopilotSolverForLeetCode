impl Solution {
    pub fn longest_substring(s: String, k: i32) -> i32 {
        

        let mut res = 0;
        let mut i = 0;
        let mut j = 0;
        let k = k as usize;
        let mut count = [0; 26];
        let mut unique = 0;
        let mut no_less_than_k = 0;
        let mut s = s.chars().collect::<Vec<char>>();
        while j < s.len() {
            let c = s[j] as usize - 'a' as usize;
            if count[c] == 0 {
                unique += 1;
            }
            count[c] += 1;
            if count[c] == k {
                no_less_than_k += 1;
            }
            while unique > k {
                let c = s[i] as usize - 'a' as usize;
                if count[c] == k {
                    no_less_than_k -= 1;
                }
                count[c] -= 1;
                if count[c] == 0 {
                    unique -= 1;
                }
                i += 1;
            }
            if unique == no_less_than_k {
                res = res.max(j - i + 1);
            }
            j += 1;
        }
        res as i32
    }
}
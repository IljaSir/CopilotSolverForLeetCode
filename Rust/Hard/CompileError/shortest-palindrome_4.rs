impl Solution {
    pub fn shortest_palindrome(s: String) -> String {
        
        let mut rev = s.clone();
        rev.reverse();
        let mut str = s + "#" + &rev;
        let mut lps = vec![0; str.len()];
        let mut i = 1;
        let mut j = 0;
        while i < str.len() {
            if str.as_bytes()[i] == str.as_bytes()[j] {
                j += 1;
                lps[i] = j;
                i += 1;
            } else {
                if j != 0 {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i += 1;
                }
            }
        }
        let mut res = s.clone();
        rev = s.clone();
        rev.reverse();
        res.push_str(&rev[lps[str.len() - 1]..]);
        res
    }
}
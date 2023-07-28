impl Solution {
    pub fn sort_string(s: String) -> String {
        
        let mut s = s.into_bytes();
        s.sort_unstable();
        let mut res = Vec::new();
        let mut i = 0;
        while i < s.len() {
            let mut j = i;
            while j < s.len() && s[j] == s[i] {
                j += 1;
            }
            res.extend_from_slice(&s[i..j]);
            i = j;
        }
        let mut i = 0;
        let mut j = res.len();
        let mut res2 = Vec::new();
        while i < j {
            let mut k = i + 1;
            while k < j && res[k] == res[i] {
                k += 1;
            }
            res2.extend_from_slice(&res[i..k]);
            i = k;
        }
        res2.reverse();
        let mut i = 0;
        let mut j = res2.len();
        let mut res3 = Vec::new();
        while i < j {
            let mut k = i + 1;
            while k < j && res2[k] == res2[i] {
                k += 1;
            }
            res3.extend_from_slice(&res2[i..k]);
            i = k;
        }
        res3.reverse();
        res3.extend(res3.iter().rev());
        String::from_utf8(res3).unwrap()
    }
}
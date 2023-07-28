impl Solution {
    pub fn nearest_palindromic(n: String) -> String {
        
        let mut s = n.chars().collect::<Vec<_>>();
        let l = s.len();
        let mut i = 0;
        let mut j = l - 1;
        while i < j {
            s[j] = s[i];
            i += 1;
            j -= 1;
        }
        let mut s1 = s.clone();
        let mut s2 = s.clone();
        let mut s3 = s.clone();
        let mut s4 = s.clone();
        let mut s5 = s.clone();
        let mut s6 = s.clone();
        let mut i = (l - 1) / 2;
        while i >= 0 {
            if s[i] != '9' {
                s1[i] = (s[i] as u8 + 1) as char;
                s1[l - 1 - i] = (s[i] as u8 + 1) as char;
                break;
            }
            i -= 1;
        }
        if i < 0 {
            s1[0] = '1';
            s1.push('1');
        }
        i = (l - 1) / 2;
        while i >= 0 {
            if s[i] != '0' {
                s2[i] = (s[i] as u8 - 1) as char;
                s2[l - 1 - i] = (s[i] as u8 - 1) as char;
                break;
            }
            i -= 1;
        }
        if i < 0 {
            s2.pop();
            s2[0] = '9';
        }
        i = (l - 1) / 2;
        while i >= 0 {
            if s[i] != '0' {
                s3[i] = (s[i] as u8 - 1) as char;
                s3[l - 1 - i] = (s[i] as u8 - 1) as char;
                break;
            }
            i -= 1;
        }
        if i < 0 {
            s3.pop();
            s3[0] = '9';
        }
        i = (l - 1) / 2;
        while i >= 0 {
            if s[i] != '9' {
                s4[i] = (s[i
    }
}
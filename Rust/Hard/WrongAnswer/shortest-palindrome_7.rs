impl Solution {
    pub fn shortest_palindrome(s: String) -> String {
        
        let s = s.as_bytes();
        let mut r = s.to_vec();
        r.reverse();
        let mut ss = s.to_vec();
        ss.push(b'#');
        ss.extend(r);
        let ss = String::from_utf8(ss).unwrap();
        let mut f = vec![0; ss.len()];
        for i in 1..ss.len() {
            let mut j = f[i - 1];
            while j > 0 && ss.as_bytes()[i] != ss.as_bytes()[j] {
                j = f[j - 1];
            }
            if ss.as_bytes()[i] == ss.as_bytes()[j] {
                j += 1;
            }
            f[i] = j;
        }
        let mut r = s.to_vec();
        r.reverse();
        let mut ss = r.to_vec();
        ss.extend(s);
        let ss = String::from_utf8(ss).unwrap();
        let mut f = vec![0; ss.len()];
        for i in 1..ss.len() {
            let mut j = f[i - 1];
            while j > 0 && ss.as_bytes()[i] != ss.as_bytes()[j] {
                j = f[j - 1];
            }
            if ss.as_bytes()[i] == ss.as_bytes()[j] {
                j += 1;
            }
            f[i] = j;
        }
        let mut r = String::new();
        for i in 0..f[ss.len() - 1] {
            r.push(ss.as_bytes()[i] as char);
        }
        let mut r = r.as_bytes().to_vec();
        r.reverse();
        let mut r = String::from_utf8(r).unwrap();
        r.push_str(&ss);
        r
    }
}
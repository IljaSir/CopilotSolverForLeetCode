impl Solution {
    pub fn next_greater_element(n: i32) -> i32 {
        

        let mut s = n.to_string().into_bytes();
        let mut i = s.len() - 1;
        while i > 0 && s[i] <= s[i-1] {
            i -= 1;
        }
        if i == 0 {
            return -1;
        }
        let mut j = s.len() - 1;
        while s[j] <= s[i-1] {
            j -= 1;
        }
        s.swap(i-1, j);
        s[i..].reverse();
        let mut s = String::from_utf8(s).unwrap();
        let res = s.parse::<i32>().unwrap();
        if res <= n {
            return -1;
        }
        res
    }
}
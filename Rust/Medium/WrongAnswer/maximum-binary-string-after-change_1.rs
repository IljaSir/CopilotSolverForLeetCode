impl Solution {
    pub fn maximum_binary_string(binary: String) -> String {
        
        let mut s = binary.chars().collect::<Vec<_>>();
        let mut i = 0;
        while i < s.len() {
            if s[i] == '0' {
                let mut j = i;
                while j < s.len() && s[j] == '0' {
                    j += 1;
                }
                if j == s.len() {
                    break;
                }
                let k = j - i;
                s[i] = '1';
                s[j] = '0';
                i = j + k;
            } else {
                i += 1;
            }
        }
        s.into_iter().collect()
    }
}
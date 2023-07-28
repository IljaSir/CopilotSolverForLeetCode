impl Solution {
    pub fn possibly_equals(s1: String, s2: String) -> bool {
        
        let mut s1 = s1.chars().collect::<Vec<_>>();
        let mut s2 = s2.chars().collect::<Vec<_>>();
        let mut i = 0;
        let mut j = 0;
        while i < s1.len() && j < s2.len() {
            if s1[i] == s2[j] {
                i += 1;
                j += 1;
                continue;
            }
            if s1[i].is_digit(10) && s2[j].is_digit(10) {
                let mut k = i;
                let mut l = j;
                while k < s1.len() && s1[k].is_digit(10) {
                    k += 1;
                }
                while l < s2.len() && s2[l].is_digit(10) {
                    l += 1;
                }
                let n1 = s1[i..k].iter().collect::<String>().parse::<i32>().unwrap();
                let n2 = s2[j..l].iter().collect::<String>().parse::<i32>().unwrap();
                if n1 != n2 {
                    return false;
                }
                i = k;
                j = l;
            } else {
                return false;
            }
        }
        i == s1.len() && j == s2.len()
    }
}
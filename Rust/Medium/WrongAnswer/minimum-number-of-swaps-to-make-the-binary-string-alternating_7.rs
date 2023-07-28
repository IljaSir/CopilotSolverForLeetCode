impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let s1 = s.chars().collect::<Vec<char>>();
        let mut s2 = s1.clone();
        let mut count = 0;
        for i in 0..s1.len() {
            if i % 2 == 0 {
                if s1[i] != '0' {
                    count += 1;
                }
                if s2[i] != '1' {
                    count += 1;
                }
            } else {
                if s1[i] != '1' {
                    count += 1;
                }
                if s2[i] != '0' {
                    count += 1;
                }
            }
        }
        if count % 2 == 1 {
            return -1;
        }
        count / 2
    }
}
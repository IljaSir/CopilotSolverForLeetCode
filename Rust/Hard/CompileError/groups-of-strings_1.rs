impl Solution {
    pub fn group_strings(words: Vec<String>) -> Vec<i32> {
        
        let mut ans = vec![0, 0];
        let mut groups = vec![];
        for word in words {
            let mut found = false;
            for group in &mut groups {
                if Solution::is_connected(word.as_str(), group[0].as_str()) {
                    group.push(word);
                    if group.len() > ans[1] as usize {
                        ans[1] = group.len() as i32;
                    }
                    found = true;
                    break;
                }
            }
            if !found {
                groups.push(vec![word]);
                ans[0] += 1;
            }
        }
        ans
    }
    
    fn is_connected(s1: &str, s2: &str) -> bool {
        if s1.len() != s2.len() {
            return false;
        }
        let mut diff = 0;
        for (c1, c2) in s1.chars().zip(s2.chars()) {
            let mut d = c1 as i32 - c2 as i32;
            if d < 0 {
                d += 26;
            }
            if diff == 0 {
                diff = d;
            } else if diff != d {
                return false;
            }
        }
        true
    }
}
impl Solution {
    pub fn find_anagrams(s: String, p: String) -> Vec<i32> {
        

        let mut p = p.into_bytes();
        p.sort();
        let mut ans = vec![];
        let s = s.as_bytes();
        for i in 0..=s.len()-p.len() {
            let mut tmp = s[i..i+p.len()].to_vec();
            tmp.sort();
            if tmp == p {
                ans.push(i as i32);
            }
        }
        ans
    }
}
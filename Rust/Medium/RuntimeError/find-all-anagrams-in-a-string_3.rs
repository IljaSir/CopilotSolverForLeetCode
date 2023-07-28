impl Solution {
    pub fn find_anagrams(s: String, p: String) -> Vec<i32> {
        

        let mut anagrams: Vec<i32> = Vec::new();
        let mut s: Vec<char> = s.chars().collect();
        let mut p: Vec<char> = p.chars().collect();
        p.sort();
        for i in 0..s.len() - p.len() + 1 {
            let mut sub: Vec<char> = s[i..i + p.len()].to_vec();
            sub.sort();
            if sub == p {
                anagrams.push(i as i32);
            }
        }
        anagrams
    }
}
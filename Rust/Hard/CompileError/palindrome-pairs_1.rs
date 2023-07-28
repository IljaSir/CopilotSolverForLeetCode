impl Solution {
    pub fn palindrome_pairs(words: Vec<String>) -> Vec<Vec<i32>> {
        
        let mut ans = vec![];
        let mut words = words.into_iter().enumerate().map(|(i, s)| (i, s.chars().collect::<Vec<_>>())).collect::<Vec<_>>();
        words.sort_by_key(|(_, s)| s.len());
        let mut map = std::collections::HashMap::new();
        for (i, s) in &words {
            map.insert(s, i);
        }
        for (i, s) in &words {
            for j in 0..=s.len() {
                if Self::is_palindrome(&s[j..]) {
                    if let Some(&k) = map.get(&s[..j].iter().rev().collect::<Vec<_>>()) {
                        if k != *i {
                            ans.push(vec![*i as i32, k as i32]);
                        }
                    }
                }
                if j > 0 && Self::is_palindrome(&s[..j]) {
                    if let Some(&k) = map.get(&s[j..].iter().rev().collect::<Vec<_>>()) {
                        if k != *i {
                            ans.push(vec![k as i32, *i as i32]);
                        }
                    }
                }
            }
        }
        ans
    }
    fn is_palindrome(s: &[char]) -> bool {
        let mut i = 0;
        let mut j = s.len() - 1;
        while i < j {
            if s[i] != s[j] {
                return false;
            }
            i += 1;
            j -= 1;
        }
        true
    }
}
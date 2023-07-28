impl Solution {
    pub fn close_strings(word1: String, word2: String) -> bool {
        
        let mut cnt1 = [0; 26];
        let mut cnt2 = [0; 26];
        let mut set1 = std::collections::BTreeSet::new();
        let mut set2 = std::collections::BTreeSet::new();
        for c in word1.chars() {
            cnt1[c as usize - 'a' as usize] += 1;
            set1.insert(c);
        }
        for c in word2.chars() {
            cnt2[c as usize - 'a' as usize] += 1;
            set2.insert(c);
        }
        set1 == set2 && cnt1.iter().copied().sorted().collect::<Vec<_>>() == cnt2.iter().copied().sorted().collect::<Vec<_>>()
    }
}
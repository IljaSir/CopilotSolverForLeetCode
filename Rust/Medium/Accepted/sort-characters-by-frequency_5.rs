impl Solution {
    pub fn frequency_sort(s: String) -> String {
        

        let mut freq = vec![0; 128];
        for c in s.chars() {
            freq[c as usize] += 1;
        }
        let mut chars: Vec<char> = s.chars().collect();
        chars.sort_by_key(|&c| std::cmp::Reverse((freq[c as usize], c)));
        chars.iter().collect()
    }
}
impl Solution {
    pub fn max_number_of_balloons(text: String) -> i32 {
        
        let mut count = vec![0; 26];
        for c in text.chars() {
            count[c as usize - 'a' as usize] += 1;
        }
        let mut min = std::i32::MAX;
        min = min.min(count['b' as usize - 'a' as usize]);
        min = min.min(count['a' as usize - 'a' as usize]);
        min = min.min(count['l' as usize - 'a' as usize] / 2);
        min = min.min(count['o' as usize - 'a' as usize] / 2);
        min = min.min(count['n' as usize - 'a' as usize]);
        min
    }
}
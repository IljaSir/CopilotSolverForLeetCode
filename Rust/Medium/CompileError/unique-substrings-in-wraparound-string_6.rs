impl Solution {
    pub fn find_substring_in_wrapround_string(s: String) -> i32 {
        

        let mut count = [0; 26];
        let mut max_len = 0;
        s.chars().for_each(|c| {
            let i = c as usize - 'a' as usize;
            max_len = if i == (count[i] + 1) % 26 { max_len + 1 } else { 1 };
            count[i] = std::cmp::max(count[i], max_len);
        });
        count.iter().sum::<i32>()
    }
}
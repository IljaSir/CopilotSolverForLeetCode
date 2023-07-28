impl Solution {
    pub fn seconds_to_remove_occurrences(s: String) -> i32 {
        
        let mut count = 0;
        let mut i = 0;
        let mut j = 0;
        let mut last = 0;
        let mut n = s.len();
        let mut str = s.chars().collect::<Vec<char>>();
        while i < n {
            while i < n && str[i] == '0' {
                i += 1;
            }
            j = i + 1;
            while j < n && str[j] == '1' {
                j += 1;
            }
            if j < n {
                count += 1;
                last = j;
            }
            i = j + 1;
        }
        if last < n {
            count += 1;
        }
        count
    }
}
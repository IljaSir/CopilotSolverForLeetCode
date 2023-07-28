impl Solution {
    pub fn count_time(time: String) -> i32 {
        
        let mut result = 0;
        let mut time = time.chars().collect::<Vec<char>>();
        for i in 0..24 {
            for j in 0..60 {
                time[0] = (i / 10 + 48) as char;
                time[1] = (i % 10 + 48) as char;
                time[3] = (j / 10 + 48) as char;
                time[4] = (j % 10 + 48) as char;
                if (time[0] != '?' && time[1] != '?' && time[3] != '?' && time[4] != '?') {
                    result += 1;
                }
            }
        }
        result
    }
}
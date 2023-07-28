impl Solution {
    pub fn maximum_population(logs: Vec<Vec<i32>>) -> i32 {
        
        let mut year = 1950;
        let mut max = 0;
        let mut max_year = 0;
        while year <= 2050 {
            let mut count = 0;
            for log in &logs {
                if year >= log[0] && year < log[1] {
                    count += 1;
                }
            }
            if count > max {
                max = count;
                max_year = year;
            }
            year += 1;
        }
        max_year
    }
}
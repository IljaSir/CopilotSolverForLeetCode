impl Solution {
    pub fn maximum_population(logs: Vec<Vec<i32>>) -> i32 {
        
        let mut births = vec![0; 101];
        let mut deaths = vec![0; 101];
        for log in logs {
            births[(log[0] - 1950) as usize] += 1;
            deaths[(log[1] - 1950) as usize] += 1;
        }
        let mut max = 0;
        let mut max_year = 0;
        let mut current = 0;
        for year in 0..101 {
            current += births[year] - deaths[year];
            if current > max {
                max_year = year;
                max = current;
            }
        }
        max_year as i32 + 1950
    }
}
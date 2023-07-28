impl Solution {
    pub fn maximum_population(logs: Vec<Vec<i32>>) -> i32 {
        
        let mut years = vec![0; 101];
        for log in logs {
            for year in log[0] - 1950..log[1] - 1950 {
                years[year as usize] += 1;
            }
        }
        years.iter().enumerate().max_by_key(|&(_, &v)| v).unwrap().0 as i32 + 1950
    }
}
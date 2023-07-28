impl Solution {
    pub fn maximum_population(logs: Vec<Vec<i32>>) -> i32 {
        
        let mut years = vec![0; 101];
        for log in logs {
            years[(log[0] - 1950) as usize] += 1;
            years[(log[1] - 1950) as usize] -= 1;
        }
        let mut sum = 0;
        let mut max = 0;
        let mut max_year = 0;
        for (i, &year) in years.iter().enumerate() {
            sum += year;
            if sum > max {
                max = sum;
                max_year = i;
            }
        }
        max_year as i32 + 1950
    }
}
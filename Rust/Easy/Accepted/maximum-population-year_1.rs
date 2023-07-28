impl Solution {
    pub fn maximum_population(logs: Vec<Vec<i32>>) -> i32 {
        
        let mut years = [0; 101];
        for log in logs {
            years[(log[0] - 1950) as usize] += 1;
            years[(log[1] - 1950) as usize] -= 1;
        }
        let mut max = 0;
        let mut max_year = 0;
        let mut count = 0;
        for i in 0..101 {
            count += years[i];
            if count > max {
                max = count;
                max_year = i;
            }
        }
        max_year as i32 + 1950
    }
}
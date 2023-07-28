impl Solution {
    pub fn maximum_population(logs: Vec<Vec<i32>>) -> i32 {
        
        let mut birth = vec![0; 101];
        let mut death = vec![0; 101];
        for log in logs {
            birth[log[0] as usize - 1950] += 1;
            death[log[1] as usize - 1950] += 1;
        }
        let mut max = 0;
        let mut sum = 0;
        let mut year = 0;
        for i in 0..101 {
            sum += birth[i];
            sum -= death[i];
            if sum > max {
                max = sum;
                year = i;
            }
        }
        year as i32 + 1950
    }
}
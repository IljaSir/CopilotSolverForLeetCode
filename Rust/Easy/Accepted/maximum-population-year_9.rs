impl Solution {
    pub fn maximum_population(logs: Vec<Vec<i32>>) -> i32 {
        
        let mut years: Vec<i32> = Vec::new();
        for i in 0..logs.len() {
            let v = logs[i].clone();
            years.push(v[0]);
            years.push(v[1]);
        }
        years.sort();
        let mut max = 0;
        let mut result = 0;
        for i in 0..years.len() {
            let mut count = 0;
            for j in 0..logs.len() {
                let v = logs[j].clone();
                if years[i] >= v[0] && years[i] < v[1] {
                    count += 1;
                }
            }
            if count > max {
                max = count;
                result = years[i];
            }
        }
        result
    }
}
impl Solution {
    pub fn most_visited(n: i32, rounds: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![];
        let mut max = 0;
        let mut count = vec![0; n as usize];
        for i in 0..rounds.len() - 1 {
            let mut start = rounds[i];
            let mut end = rounds[i + 1];
            if start > end {
                end += n;
            }
            for j in start..=end {
                count[(j - 1) as usize] += 1;
                if count[(j - 1) as usize] > max {
                    max = count[(j - 1) as usize];
                }
            }
        }
        for i in 0..count.len() {
            if count[i] == max {
                res.push((i + 1) as i32);
            }
        }
        res
    }
}
impl Solution {
    pub fn most_visited(n: i32, rounds: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![0; n as usize];
        let mut i = rounds[0] as usize - 1;
        let mut j = rounds[rounds.len() - 1] as usize - 1;
        if i <= j {
            for k in i..=j {
                res[k] += 1;
            }
        } else {
            for k in i..n as usize {
                res[k] += 1;
            }
            for k in 0..=j {
                res[k] += 1;
            }
        }
        let mut ans = Vec::new();
        let mut max = 0;
        for i in 0..n as usize {
            if res[i] > max {
                max = res[i];
            }
        }
        for i in 0..n as usize {
            if res[i] == max {
                ans.push((i + 1) as i32);
            }
        }
        ans
    }
}
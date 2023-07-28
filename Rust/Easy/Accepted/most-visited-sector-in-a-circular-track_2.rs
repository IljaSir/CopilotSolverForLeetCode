impl Solution {
    pub fn most_visited(n: i32, rounds: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![0; n as usize];
        let mut start = rounds[0] as usize;
        let mut end = rounds[rounds.len()-1] as usize;
        if start <= end {
            for i in start..=end {
                res[i-1] += 1;
            }
        } else {
            for i in 0..end {
                res[i] += 1;
            }
            for i in start-1..n as usize {
                res[i] += 1;
            }
        }
        let mut ans = vec![];
        let mut max = 0;
        for i in 0..n as usize {
            if res[i] > max {
                max = res[i];
                ans = vec![i as i32 + 1];
            } else if res[i] == max {
                ans.push(i as i32 + 1);
            }
        }
        ans
    }
}
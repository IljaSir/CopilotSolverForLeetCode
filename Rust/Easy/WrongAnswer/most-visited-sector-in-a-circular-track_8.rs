impl Solution {
    pub fn most_visited(n: i32, rounds: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![0; n as usize];
        let mut max = 0;
        let mut pre = rounds[0];
        for i in 1..rounds.len() {
            let cur = rounds[i];
            if pre <= cur {
                for j in pre..=cur {
                    res[j as usize - 1] += 1;
                    max = max.max(res[j as usize - 1]);
                }
            } else {
                for j in 1..=cur {
                    res[j as usize - 1] += 1;
                    max = max.max(res[j as usize - 1]);
                }
                for j in pre..=n {
                    res[j as usize - 1] += 1;
                    max = max.max(res[j as usize - 1]);
                }
            }
            pre = cur;
        }
        res.into_iter().enumerate().filter(|(_, v)| *v == max).map(|(i, _)| (i + 1) as i32).collect()
    }
}
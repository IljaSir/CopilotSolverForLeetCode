impl Solution {
    pub fn most_visited(n: i32, rounds: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![0; n as usize];
        let mut i = 0;
        let mut j = rounds[0] as usize - 1;
        while i < rounds.len() - 1 {
            res[j] += 1;
            if rounds[i] <= rounds[i+1] {
                j = (j + 1) % n as usize;
            } else {
                j = (j + n as usize - 1) % n as usize;
            }
            if j + 1 == rounds[i+1] as usize {
                i += 1;
            }
        }
        res[j] += 1;
        let max = res.iter().max().unwrap();
        res.iter()
            .enumerate()
            .filter_map(|(i, x)| if x == max { Some(i as i32 + 1) } else { None })
            .collect()
    }
}
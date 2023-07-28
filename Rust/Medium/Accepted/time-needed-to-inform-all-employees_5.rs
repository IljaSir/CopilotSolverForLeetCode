impl Solution {
    pub fn num_of_minutes(n: i32, head_id: i32, manager: Vec<i32>, inform_time: Vec<i32>) -> i32 {
        
        let mut subordinates = vec![vec![]; n as usize];
        for (i, &m) in manager.iter().enumerate() {
            if m != -1 {
                subordinates[m as usize].push(i as i32);
            }
        }
        fn dfs(id: i32, subordinates: &Vec<Vec<i32>>, inform_time: &Vec<i32>) -> i32 {
            let mut max = 0;
            for &s in &subordinates[id as usize] {
                max = std::cmp::max(max, dfs(s, subordinates, inform_time));
            }
            max + inform_time[id as usize]
        }
        dfs(head_id, &subordinates, &inform_time)
    }
}
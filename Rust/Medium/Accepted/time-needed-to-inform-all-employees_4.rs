impl Solution {
    pub fn num_of_minutes(n: i32, head_id: i32, manager: Vec<i32>, inform_time: Vec<i32>) -> i32 {
        
        let mut subordinates = vec![vec![]; n as usize];
        for (i, &m) in manager.iter().enumerate() {
            if m != -1 {
                subordinates[m as usize].push(i as i32);
            }
        }

        fn dfs(i: i32, subordinates: &Vec<Vec<i32>>, inform_time: &Vec<i32>) -> i32 {
            if subordinates[i as usize].len() == 0 {
                return 0;
            }
            let mut max = 0;
            for &s in &subordinates[i as usize] {
                max = max.max(dfs(s, subordinates, inform_time));
            }
            max + inform_time[i as usize]
        }

        dfs(head_id, &subordinates, &inform_time)
    }
}
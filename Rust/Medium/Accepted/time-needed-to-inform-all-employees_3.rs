impl Solution {
    pub fn num_of_minutes(n: i32, head_id: i32, manager: Vec<i32>, inform_time: Vec<i32>) -> i32 {
        
        let mut subordinates = vec![Vec::new(); n as usize];
        for i in 0..n {
            if manager[i as usize] != -1 {
                subordinates[manager[i as usize] as usize].push(i);
            }
        }
        
        fn dfs(subordinates: &Vec<Vec<i32>>, inform_time: &Vec<i32>, i: i32) -> i32 {
            if subordinates[i as usize].is_empty() {
                return 0;
            }
            let mut max = 0;
            for &j in subordinates[i as usize].iter() {
                max = max.max(dfs(subordinates, inform_time, j));
            }
            max + inform_time[i as usize]
        }
        
        dfs(&subordinates, &inform_time, head_id)
    }
}